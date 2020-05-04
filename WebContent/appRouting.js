function enrutamiento ($routeProvider, $locationProvider){
    $routeProvider
        .when("/", {
            controller: "appCtrl",
            controllerAs: "ctx",
            templateUrl: "plugins/inicio-plugin/inicio-plugin.html"
        })
        .when("/inicio", {
            controller: "inicioController",
            controllerAs: "ctx",
            templateUrl: "plugins/productos-component/productos-component.html"
        })
        .otherwise({
            redirectTo: '/'
        });
}

export default enrutamiento;