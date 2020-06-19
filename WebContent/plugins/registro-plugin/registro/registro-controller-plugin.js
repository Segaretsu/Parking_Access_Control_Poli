app.controller("registroController", ['$scope', '$http', function($scope, $http){
	/* Definicion variables */
	ctx = $scope
	ctx.mostrar = true;
	ctx.listaTipoUsuarios;
	ctx.listaTipoDocumentos;
	ctx.usuarioRegistro;
	ctx.formularios;
	ctx.indexFormularioActual;
	/* Declaracion Metodos */
	ctx.init = init;
	ctx.registrarUsuario = registrarUsuario;
	ctx.getListaTipoUsuarios = getListaTipoUsuarios;
	ctx.getListaTipoDocumentos = getListaTipoDocumentos;
	ctx.setUsuarioRegistro = setUsuarioRegistro;
	ctx.validarFormulario = validarFormulario;
	ctx.guardarUsuario = guardarUsuario;
	
	// toda el codigo del controlador de inicio aqui
    this.$onInit = function () {
    	
    }
	
	/* Definicion Metodos */
    
    function init() {
    	ctx.getListaTipoUsuarios();
    	ctx.getListaTipoDocumentos();
    	ctx.formularios = [false,false,false];
    	ctx.indexFormularioActual = 0;
    }
    
    function guardarUsuario() {
    	ctx.setUsuarioRegistro();
    	if(ctx.validarFormulario(ctx.usuarioRegistro)){
    		sessionStorage.setItem('usuarioARegistrar', ctx.usuarioRegistro);
    		ctx.formularios[ctx.indexFormularioActual] = true;
    		ctx.indexFormularioActual++;
    	} else {
    		alert('Valida la información del formulario por favor');
    	}
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
	
	
	/*GETTERS AND SETTERS*/
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
				"idTipoDocumento":"1",
				"descripcion":"Cedula de ciudadania"
			}
		];
		
		$http.get('/Parking_Access_Control_Poli/Parking-back/tipo/documentos').then(function(response) {
			console.log(response)
			if(response.status == $HTTP.Ok) {
				ctx.listaTipoDocumentos = response.data;
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
	
	function validarFormulario ($usuario) {
		if(!$usuario.idTipoPerfil){
			return false;
		}
		if(!$usuario.idTipoDocumento) {
			return false;
		}
		if(!$usuario.numeroDocumento){
			return false;
		}
		if(!$usuario.nombre){
			return false;
		}
		if(!$usuario.apellidos){
			return false;
		}
		if(!$usuario.telefono){
			return false;		
		}		
		if(!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test($usuario.correo))){
			return false;
		}
		return true;
	}
	
	ctx.init();
}])