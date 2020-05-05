app.controller("registroController", ['$scope', '$http', function($scope, $http){
	ctx = $scope
	ctx.nombre = "Jhon solo";
	ctx.apellido = "hace pagina";
	ctx.mostrar = true;
	
	ctx.registrarNombre = function(){
		$http.get('Parking-back/pruebas/nombreEnviado/' + ctx.nombre).then(function(response){
			/*if(ctx.mostrar){
			   ctx.mostrar = false;	
			}else{
				ctx.mostrar = true;
			}*/
			ctx.mostrar = (ctx.mostrar)?false:true;
			//alert(JSON.stringify(response.data) + "Lo hace solo, la chimb***");
		}).catch(function(){
			alert("Se nos cayo el sv");
		});
	}
}])