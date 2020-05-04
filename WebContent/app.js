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
        .otherwise({
            redirectTo: '/'
        });
});


app.controller("appCtrl", ['$scope', '$http', function ($scope, $http){
	/** Definición de variables*/
	ctx = $scope;
}]);

app.controller("appMenu", ['$scope', function ($scope){
	/** Definición de variables */
	ctx = $scope;
	ctx.pantallaActual = 'Inicio';
	var URLactual = window.location;
	/** Definición de métodos */
	ctx.cerrarSession = cerrarSession;
	ctx.setNombrePantallaActual = setNombrePantallaActual;
	
	//toda el código del controlador de inicio aquí
    this.$onInit = function () {
    	ctx.setNombrePantallaActual();
    }
    
    
    /** Creación de Métodos */
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





