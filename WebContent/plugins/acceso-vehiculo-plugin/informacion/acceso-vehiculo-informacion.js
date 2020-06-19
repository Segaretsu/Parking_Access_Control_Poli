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
			//debugger;
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
			} else {
				console.log("PAILAS ENTRO A ESE ELSE DESPUES DE UNDEFINED")
			}
		}).catch(function(){
			//debugger;
			alert("Se nos cayo el sv");
		});
	}
	
	/*Implementacion metodos*/
	ctx.init();
}]);