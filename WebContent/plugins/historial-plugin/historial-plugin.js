app.controller("historialController", ['$scope', '$http', function($scope, $http){
	/* Definicion variables */
	ctx = $scope;
	ctx.placa;
	ctx.fechaInicio;
	ctx.fechaFin;
	ctx.busquedaSeEjecuto;
	ctx.listaFechas;
	ctx.informacionVehiculo;
	ctx.informacionUsuario;
	
	ctx.listaTipoVehiculos;
	/*Decalracion metodos*/
	ctx.init = init;
	ctx.listarFechas = listarFechas;
	ctx.consultarInformacion = consultarInformacion;
	ctx.getDateToTimeStamp = getDateToTimeStamp;
	ctx.consultarInformacionVehiculo = consultarInformacionVehiculo;
	ctx.consultarInformacionUsuario = consultarInformacionUsuario;
	ctx.formatoFecha = formatoFecha;
	
	ctx.getListaTipoVehiculos = getListaTipoVehiculos;
	
	/*Definicion metodos*/
	function init(){
		ctx.getListaTipoVehiculos();
		if(sessionStorage.getItem('parametrosBusqueda')) {
			let criterioBusqueda = JSON.parse(sessionStorage.getItem('parametrosBusqueda'));
			ctx.placa = criterioBusqueda.placa;
			ctx.fechaInicio = new Date(criterioBusqueda.fechaInicio.substring(0,10));
			ctx.fechaFin =  new Date(criterioBusqueda.fechaFin.substring(0,10));
			ctx.consultarInformacion();
			sessionStorage.removeItem('parametrosBusqueda');
		} else {
			ctx.busquedaSeEjecuto = false;
			const date = new Date()
			const fechaNoDate = ctx.getDateToTimeStamp(date)
			const fechaActual = new Date(fechaNoDate.replace(/-/g, '\/'));
			ctx.fechaInicio = fechaActual;
			ctx.fechaFin = fechaActual;
			//Validaciones de campos
			$('#fechaFin').attr("max", fechaNoDate);
			$('#fechaInicio').attr("max", fechaNoDate);
		}
	}
	
	function consultarInformacion () {
		ctx.listarFechas();
		ctx.consultarInformacionVehiculo();
		ctx.busquedaSeEjecuto = true;
	}
	
	function consultarInformacionVehiculo () {
		$http.get('/Parking_Access_Control_Poli/Parking-back/vehiculo/consultar/placa/' + ctx.placa).then(function(response) {
			if (!(typeof response.data === "undefined")) {
				console.log(ctx.informacionVehiculo);
				console.log('Hay informacion vehiculo');
				ctx.informacionVehiculo = response.data;
				ctx.informacionVehiculo.tipoVehiculo = ctx.listaTipoVehiculos.filter(function (tv) { return tv.idTipoVehiculo == ctx.informacionVehiculo.idTipoVehiculo})[0];
				ctx.consultarInformacionUsuario();
			}
		}).catch(function(){
			alert('La información introducida no es correcta')
		});
	}
	
	function consultarInformacionUsuario () {
		$http.get('/Parking_Access_Control_Poli/Parking-back/usuario/consultar/idUsuario/' + ctx.informacionVehiculo.idUsuario).then(function(response) {
			console.log(response)
			if (!(typeof response.data === "undefined")) {
				console.log('Hay informacion del usuario');
				ctx.informacionUsuario = response.data;
			}
		}).catch(function(){
			alert('La información introducida no es correcta')
		});
	}
	
	function listarFechas (){
		let fechaInicial = ctx.getDateToTimeStamp(ctx.fechaInicio) + ' 00:00:00';
		let fechaFinal = ctx.getDateToTimeStamp(ctx.fechaFin) + ' 23:59:00';
		console.log(fechaInicial)
		console.log(fechaFinal)
		$http.get('/Parking_Access_Control_Poli/Parking-back/registro/fechas/p/' + ctx.placa + '/FI/'+ fechaInicial +'/FF/' + fechaFinal).then(function(response) {
			console.log(response)
			//debugger;
			if (!(typeof response.data === "undefined")) {
				console.log('hay data');
				ctx.listaFechas = response.data;
				for(let i = 0; i < ctx.listaFechas.length; i++) {
					ctx.listaFechas[i].numero = (i + 1);
					if(typeof ctx.listaFechas[i].fechaSalida === "undefined") {
						ctx.listaFechas[i].fechaSalida = 'No registra'
					} else {
						ctx.listaFechas[i].fechaSalida = ctx.formatoFecha(ctx.listaFechas[i].fechaSalida);
					}
					ctx.listaFechas[i].fechaIngreso = ctx.formatoFecha(ctx.listaFechas[i].fechaIngreso);
				}
			}
		}).catch(function(){
			//debugger;
			alert('La información introducida no es correcta')
		});
	}
	
	function getListaTipoVehiculos() {
		ctx.listaTipoVehiculos = [ { "idTipoVehiculo":"1", "descripcion":"Carro" } ];
		$http.get('/Parking_Access_Control_Poli/Parking-back/tipo/vehiculos').then(function(response) {
			console.log(response)
			if(response.status == $HTTP.Ok) {
				ctx.listaTipoVehiculos = response.data;
			}
		}).catch(function(){
			alert("Estamos en mantenimiento, vuelva más tarde por favor ;)");
		});
	}
	
	function getDateToTimeStamp (fecha) {
		const ye = new Intl.DateTimeFormat('es', { year: 'numeric' }).format(fecha);
		const mo = new Intl.DateTimeFormat('es', { month: '2-digit' }).format(fecha);
		const da = new Intl.DateTimeFormat('es', { day: '2-digit' }).format(fecha);
		const fechaNoDate = ye + "-" + mo + "-"+da;
		return fechaNoDate;
	}
	
	function formatoFecha (fecha) {
		fecha = fecha.replace('Z[UTC]', '');
		return fecha.replace('T', ' ');
	}
	
	/*Implementacion metodos*/
	ctx.init();
}]);