app.controller("registroController", ['$scope', '$http', function($scope, $http){
	/*Definicion variables*/
	ctx = $scope
	ctx.mostrar = true;
	ctx.listaTipoUsuarios;
	ctx.usuarioRegistro;
	/*Definicion Metodos*/
	ctx.init = init;
	ctx.registrarUsuario = registrarUsuario;
	ctx.getListaTipoUsuarios = getListaTipoUsuarios;
	
	//toda el codigo del controlador de inicio aqu�
    this.$onInit = function () {
    	ctx.getListaTipoUsuarios();
    }
	
	/*Declaracion Metodos*/
    
    function init() {
    	ctx.getListaTipoUsuarios();
    }
	
	function registrarUsuario () {
		$http.get('Parking-back/pruebas/nombreEnviado/' + ctx.nombre).then(function(response){
			ctx.mostrar = (ctx.mostrar)?false:true;
		}).catch(function(){
			alert("Se nos cayo el sv");
		});
	}
	
	function getListaTipoUsuarios () {
		ctx.listaTipoUsuarios = [
			{
				"id":"1",
				"name":"Profesor"
			}
		];
	}
	
	ctx.init();
}])