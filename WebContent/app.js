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
        .when("/registro", {
            controller: "registroController",
            controllerAs: "ctx",
            templateUrl: "./plugins/registro-plugin/registro-plugin.html"
        })
        .otherwise({
            redirectTo: '/'
        });
});


app.controller("appCtrl", ['$scope', '$http', function ($scope, $http){
	/** Definici�n de variables*/
	ctx = $scope;
}]);

app.controller("appMenu", ['$scope', function ($scope){
	/** Definici�n de variables */
	ctx = $scope;
	ctx.pantallaActual = 'Inicio';
	var URLactual = window.location;
	/** Definici�n de m�todos */
	ctx.cerrarSession = cerrarSession;
	ctx.setNombrePantallaActual = setNombrePantallaActual;
	
	//toda el c�digo del controlador de inicio aqu�
    this.$onInit = function () {
    	ctx.setNombrePantallaActual();
    }
    
    
    /** Creaci�n de M�todos */
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





