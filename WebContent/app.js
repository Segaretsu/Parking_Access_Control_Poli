//import appRouting from "./appRouting.js";

var app = angular.module("app", ["ngRoute"]);

app.config(function($routeProvider, $locationProvider){
    $routeProvider
        .when("/", {
            controller: "appCtrl",
            controllerAs: "ctx",
            templateUrl: "./plugins/inicio-plugin/inicio-plugin.html"
        })
        .when("/inicio", {
            controller: "inicioController",
            controllerAs: "ctx",
            templateUrl: "./plugins/productos-component/productos-component.html"
        })
        .when("/panel-registro", {
            templateUrl: "./plugins/registro-plugin/registro-panel-control.html"
        })
        .when("/acceso-vehiculos", {
            controller: "accesoVehiculoController",
            controllerAs: "ctx",
            templateUrl: "./plugins/acceso-vehiculo-plugin/informacion/acceso-vehiculo-informacion.html"
        })

        .when("/registro", {
            controller: "registroController",
            controllerAs: "ctx",
            templateUrl: "./plugins/registro-plugin/registro/registro-plugin.html"
        })
        
        .otherwise({
            redirectTo: '/'
        });
});

app.controller("appMenu", ['$scope', '$http', function ($scope, $http){
	/** Definicion de variables */
	ctx = $scope;
	ctx.pantallaActual = 'Inicio';
	var URLactual = window.location;
	/** Definicion de metodos */
	ctx.cerrarSession = cerrarSession;
	ctx.setNombrePantallaActual = setNombrePantallaActual;
	
	//toda el codigo del controlador de inicio aqu�
    this.$onInit = function () {
    	ctx.setNombrePantallaActual();
    }
    
    
    /** Creacion de Metodos */
    function cerrarSession() {
		localStorage.clear();
    	location.href="http://localhost:8080/Parking_Access_Control_Poli/";
	}
    
    function setNombrePantallaActual() {
        var URLhash = URLactual.hash;
        if(URLhash == '#/' || URLhash == '#!/') {
        	ctx.pantallaActual = 'Inicio';
        } else {
            /*Tomamos el nombre de la pantalla y lo ponemos mayuscula*/
        	ctx.pantallaActual = URLhash.substring(2).toUpperCase();
        }
    }
	
}]);

app.controller("appCtrl", ['$scope', '$http', function ($scope, $http){
	/** Definicion de variables*/
	ctx = $scope;
	ctx.listaTipoVehiculos;
	/** Definicion de metodos */
	ctx.ingresarInvitado = ingresarInvitado;
	ctx.getListaTipoVehiculos = getListaTipoVehiculos;
	ctx.salidaInvitado = salidaInvitado;
	
	/*INICIO*/
	ctx.init = function () {
		ctx.getListaTipoVehiculos();
	}
	
	/** Creacion de Metodos */
	function ingresarInvitado () {
    	let placa = $('#placaInvitado').val();
    	let idTipoVehiculo = $('#idTipoVehiculoInvitado').val();
    	//         /Parking_Access_Control_Poli/Parking-back/tipo/vehiculos
    	$http.get('/Parking_Access_Control_Poli/Parking-back/registro/ingreso/placa/' + placa + '/idTipoV/' + idTipoVehiculo).then(function(response) {
			console.log(response);
			if (response.data == "0") {
				alert('No se registro el invitado');
			} else {
				alert('Registro exitoso');
			}
		}).catch(function(){
			alert("Se nos cayo el sv");
		});
    }
	
	function salidaInvitado () {
    	let placa = $('#placaInvitadoSalida').val();
    	$http.get('/Parking_Access_Control_Poli/Parking-back/registro/salida/placa/' + placa).then(function(response) {
			console.log(response);
			if (response.data == "0") {
				alert('No se registro el invitado');
			} else {
				alert('Registro exitoso');
			}
		}).catch(function(){
			alert("Se nos cayo el sv");
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
			alert("Estamos en mantenimiento, vuelva m�s tarde por favor ;)");
		});
	}
	
	ctx.init();
	
}]);



