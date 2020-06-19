app.controller("registroController", ['$scope', '$http', function($scope, $http){
	/* Definicion variables */
	ctx = $scope
	ctx.mostrar = true;
	/*Listas*/
	ctx.listaTipoUsuarios;
	ctx.listaTipoDocumentos;
	ctx.listaTipoVehiculos;
	ctx.listaMarcas;
	ctx.ListaColores;
	/*variables*/
	ctx.usuarioRegistro;
	ctx.vehiculoRegistro;
	ctx.tarjetaRegistro;
	ctx.formularios;
	ctx.indexFormularioActual;
	/* Declaracion Metodos */
	ctx.init = init;
	/*Listas tipo*/
	ctx.getListaTipoUsuarios = getListaTipoUsuarios;
	ctx.getListaTipoDocumentos = getListaTipoDocumentos;
	ctx.getListaMarcas = getListaMarcas;
	ctx.getListaColores = getListaColores;
	ctx.getListaTipoVehiculos = getListaTipoVehiculos;
	/*Validaciones*/
	ctx.validarFormulario = validarFormulario;
	ctx.validarFormularioVehiculo = validarFormularioVehiculo;
	/*Guardados*/
	ctx.guardarUsuario = guardarUsuario;
	ctx.guardarVehiculo = guardarVehiculo;
	/*Utiles*/
	ctx.avanzar = avanzar;
	ctx.volver = volver;
	/*Setters Metodos*/
	ctx.setUsuarioRegistro = setUsuarioRegistro;
	ctx.setVehiculoRegistro = setVehiculoRegistro;
	/*Registros a db*/
	ctx.registrar = registrar;
	ctx.registrarVehiculo = registrarVehiculo;
	ctx.registrarTarjeta = registrarTarjeta;
	
	// toda el codigo del controlador de inicio aqui
    this.$onInit = function () {
    	
    }
	
	/* Definicion Metodos */
    
    function init() {
    	ctx.getListaTipoUsuarios();
    	ctx.getListaTipoDocumentos();
    	ctx.getListaMarcas();
    	ctx.getListaColores();
    	ctx.getListaTipoVehiculos();
    	ctx.formularios = [true,false,false];
    	ctx.indexFormularioActual = 0;
    	ctx.tarjetaRegistro = {};
    }
    
    function guardarUsuario() {
    	ctx.setUsuarioRegistro();
    	if(ctx.validarFormulario(ctx.usuarioRegistro)){
    		sessionStorage.setItem('usuarioARegistrar', JSON.stringify(ctx.usuarioRegistro));
    		ctx.avanzar();
    	} else {
    		alert('Valida la información del formulario por favor');
    	}
    }
    
    function guardarVehiculo() {
    	ctx.setVehiculoRegistro();
    	if(ctx.validarFormularioVehiculo(ctx.vehiculoRegistro)){
    		sessionStorage.setItem('vehiculoARegistrar', JSON.stringify(ctx.vehiculoRegistro));
    		ctx.avanzar();
    	} else {
    		alert('Valida la información del formulario por favor');
    	}
    }
	
	function registrar () {
		ctx.tarjetaRegistro.numeroTarjeta = null;
		ctx.tarjetaRegistro.numeroTarjeta = $("#numeroTarjeta").val();
		if(ctx.tarjetaRegistro){
			$http.post('/Parking_Access_Control_Poli/Parking-back/usuario/crear', ctx.usuarioRegistro).then(function(response) {
				console.log(response)
				if (response.data == "0") {
					alert('usuario no registrado');
				} else if (response.data == "-1") {
					alert('usuario existente, no se tuvo que registrar');
				} else {
					ctx.vehiculoRegistro.idUsuario = response.data;
					ctx.registrarTarjeta(ctx.vehiculoRegistro);
				}
			}).catch(function(){
				alert("Se nos cayo el sv");
			});
		} else {
			alert('Ingrese la tarjeta');		}
	}
	
	function registrarVehiculo ($vehiculo) {
		$http.post('/Parking_Access_Control_Poli/Parking-back/vehiculo/crear', $vehiculo).then(function(response) {
			console.log(response)
			if (response.data == "0") {
				alert('Vehículo no registrado');
			} else if (response.data == "-1") {
				alert('Vehículo existente, no se tuvo que registrar');
			}
		}).catch(function(){
			alert("Se nos cayo el sv");
		});
	}
	
	function registrarTarjeta ($vehiculo) {
		$http.post('/Parking_Access_Control_Poli/Parking-back/tarjeta/crear', ctx.tarjetaRegistro).then(function(response) {
			console.log(response)
			if (response.data == "0") {
				alert('No se registro la tarjeta');
			} else if (response.data == "-1") {
				alert('La tarjeta ya existente');
			} else {
				$vehiculo.idtarjeta = response.data;
				ctx.registrarVehiculo($vehiculo);
			}
		}).catch(function(){
			alert("Se nos cayo el sv");
		});
	}
	
	
	/*GETTERS AND SETTERS*/
	function getListaTipoUsuarios () {
		ctx.listaTipoUsuarios = [{"id":"1","name":"Profesor"}];
	}
	
	function getListaTipoDocumentos () {
		ctx.listaTipoDocumentos = [{"idTipoDocumento":"1","descripcion":"Cedula de ciudadania"}];
		
		$http.get('/Parking_Access_Control_Poli/Parking-back/tipo/documentos').then(function(response) {
			console.log(response)
			if(response.status == $HTTP.Ok) {
				ctx.listaTipoDocumentos = response.data;
			}
		}).catch(function(){
			alert("Estamos en mantenimiento, vuelva más tarde por favor ;)");
		});
	}
	
	function getListaColores () {
		ctx.listaColores = [{"idColor":"1","descripcion":"Negro"}];
		
		$http.get('/Parking_Access_Control_Poli/Parking-back/tipo/colores').then(function(response) {
			console.log(response)
			if(response.status == $HTTP.Ok) {
				ctx.listaColores = response.data;
			}
		}).catch(function(){
			alert("Estamos en mantenimiento, vuelva más tarde por favor ;)");
		});
	}
	
	function getListaMarcas() {
		ctx.listaMarcas = [ { "idMarca":"1", "descripcion":"Toyota" } ];
		$http.get('/Parking_Access_Control_Poli/Parking-back/tipo/marcas').then(function(response) {
			console.log(response)
			if(response.status == $HTTP.Ok) {
				ctx.listaMarcas = response.data;
			}
		}).catch(function(){
			alert("Estamos en mantenimiento, vuelva más tarde por favor ;)");
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
	
	function setUsuarioRegistro() {
		ctx.usuarioRegistro = {
				"idTipoPerfil": $("#selectTipoDocumento").val(),
				"idTipoDocumento": $("#tipoDocumento").val(),
				"numeroDocumento": $("#numeroDocumento").val(),
				"nombre": $("#nombreUsuario").val(),
				"apellidos": $("#apellidosUsuario").val(),
				"telefono": $("#telefonoUsuario").val(),
				"correo": $("#correoUsuario").val()
		};
	}
	
	function setVehiculoRegistro () {
		ctx.vehiculoRegistro = {
				"idTipoVehiculo": $("#idTipoVehiculo").val(),
				"idMarca": $("#idMarca").val(),
				"idColor": $("#idColor").val(),
				"placa": $("#placa").val(),
				"modelo": $("#modelo").val(),
				"numeroPuertas": $("#numeroPuertas").val(),
				"numeroChasis": $("#numeroChasis").val()
		};
	}
	
	function validarFormularioVehiculo($vehiculo){
		if(!$vehiculo.idTipoVehiculo){ return false; }
		if(!$vehiculo.idMarca){ return false; }
		if(!$vehiculo.idColor){ return false; }
		if(!$vehiculo.placa){ return false; }
		if(!$vehiculo.modelo){ return false; }
		if(!$vehiculo.numeroPuertas){ return false; }
		if(!$vehiculo.numeroChasis){ return false; }
		return true;
	}
	
	function validarFormulario ($usuario) {
		if(!$usuario.idTipoPerfil){ return false; }
		if(!$usuario.idTipoDocumento) { return false; }
		if(!$usuario.numeroDocumento){ return false; }
		if(!$usuario.nombre){ return false; }
		if(!$usuario.apellidos){ return false; }
		if(!$usuario.telefono){ return false; }		
		if(!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test($usuario.correo))){ return false; }
		return true;
	}
	
	function avanzar(){
		ctx.formularios[ctx.indexFormularioActual] = false;
		ctx.indexFormularioActual = ctx.indexFormularioActual + 1;
		ctx.formularios[ctx.indexFormularioActual] = true;
	}
	
	function volver(){
		ctx.formularios[ctx.indexFormularioActual] = false;
		ctx.indexFormularioActual = ctx.indexFormularioActual - 1;
		ctx.formularios[ctx.indexFormularioActual] = true;
	}
	
	ctx.init();
}])