app.controller("accesoVehiculoController", ['$scope', '$http', function($scope, $http){
	/* Definicion variables */
	ctx = $scope
	ctx.mostrar = true;
	ctx.cantidadDentro;
	ctx.cantidadFuera;
	/*ctx.listaVehiculosDentro;
	ctx.listaVehiculosFuera;*/
	/*Decalracion metodos*/
	ctx.listarVehiculosDentro = listarVehiculosDentro;
	ctx.init = init;
	ctx.verDetalleVehiculoDentro = verDetalleVehiculoDentro;
	ctx.verDetalleVehiculoFuera = verDetalleVehiculoFuera;
	/*Definicion metodos*/
	function init(){
		ctx.cantidadDentro = 5;
		ctx.cantidadFuera = 5;
		ctx.listarVehiculosDentro(ctx.cantidadDentro, true);
		ctx.listarVehiculosDentro(ctx.cantidadFuera, false);
	}
	
	function listarVehiculosDentro($cantidadDatos, $vehiculosDentro ){
		$http.get('/Parking_Access_Control_Poli/Parking-back/acceso-vehiculo/listarVehiculos/' + $cantidadDatos + '/' + $vehiculosDentro ).then(function(response) {
			console.log(response)
			if (!(typeof response.data === "undefined")) {
				if($vehiculosDentro){
					ctx.cantidadDentro = $cantidadDatos;
					ctx.listaVehiculosDentro = response.data;
					for(let i = 0; i < ctx.listaVehiculosDentro.length; i++){
						ctx.listaVehiculosDentro[i].numero = i + 1;
					}
				}else{
					ctx.cantidadFuera = $cantidadDatos;
					ctx.listaVehiculosFuera = response.data;
					for(let i = 0; i < ctx.listaVehiculosFuera.length; i++){
						ctx.listaVehiculosFuera[i].numero = i + 1;
					}
				}
			}
		}).catch(function(){
			console.log("Se nos cayo el sv");
		});
	}
	
	function verDetalleVehiculoDentro (index) {
		index = index - 1;
		let parametrosBusqueda = {
			'placa': ctx.listaVehiculosDentro[index].placa,
			'fechaInicio': ctx.listaVehiculosDentro[index].horaEntrada,
			'fechaFin': ctx.listaVehiculosDentro[index].horaSalida
		};
		sessionStorage.setItem('parametrosBusqueda', JSON.stringify(parametrosBusqueda));
		window.location.href = $CONFIG.url + '#!/consulta-historial';
	}
	
	function verDetalleVehiculoFuera (index) {
		index = index - 1;
		let parametrosBusqueda = {
			'placa': ctx.listaVehiculosFuera[index].placa,
			'fechaInicio': ctx.listaVehiculosFuera[index].horaEntrada,
			'fechaFin': ctx.listaVehiculosFuera[index].horaSalida
		};
		sessionStorage.setItem('parametrosBusqueda', JSON.stringify(parametrosBusqueda));
		window.location.href = $CONFIG.url + '#!/consulta-historial';
	}
	
	/*Implementacion metodos*/
	ctx.init();
}]);