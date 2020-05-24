app.controller("registroController", ['$scope', '$http', function($scope, $http){
	/* Definicion variables */
	ctx = $scope
	ctx.mostrar = true;
	ctx.listaTipoUsuarios;
	ctx.listaTipoDocumentos;
	ctx.usuarioRegistro;
	/* Definicion Metodos */
	ctx.init = init;
	ctx.registrarUsuario = registrarUsuario;
	ctx.getListaTipoUsuarios = getListaTipoUsuarios;
	ctx.getListaTipoDocumentos = getListaTipoDocumentos;
	ctx.setUsuarioRegistro = setUsuarioRegistro;
	
	// toda el codigo del controlador de inicio aqui
    this.$onInit = function () {
    	
    }
	
	/* Declaracion Metodos */
    
    function init() {
    	ctx.getListaTipoUsuarios();
    	ctx.getListaTipoDocumentos();
    }
	
	function registrarUsuario () {
		
		ctx.setUsuarioRegistro();
		
		$http.post('/Parking_Access_Control_Poli/Parking-back/usuario/crear', ctx.usuarioRegistro).then(function(response) {
			console.log(response)
			if (response.data == "0") {
				alert('usuario no registrado');
			} else if (response.data == "-1") {
				alert('usuario existente, no se tuvo que registrar')
			}
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
	
	function getListaTipoDocumentos () {
		ctx.listaTipoDocumentos = [
			{
				"id":"1",
				"name":"Cedula de ciudadania"
			}
		];
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
	
	ctx.init();
}])