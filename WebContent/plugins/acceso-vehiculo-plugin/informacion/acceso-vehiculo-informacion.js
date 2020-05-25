app.controller("accesoVehiculoController", ['$scope', '$http', function($scope, $http){
	/* Definicion variables */
	ctx = $scope
	ctx.mostrar = true;
	
	ctx.listaVehiculosDentro = [
		{
			"tv" : "directions_car",
			"placa" : "ABC123",
			"color" : "Black",
			"modelo" : "2020",
			"tu" : "Profesor",
			"dueno" : "Andres Felipe"
		}
	];
	
	ctx.listaVehiculosFuera = [
		{
			"tv" : "directions_car",
			"placa" : "ABC123",
			"color" : "Black",
			"modelo" : "2020",
			"tu" : "Profesor",
			"dueno" : "Andres Felipe"
		}
	];
}]);