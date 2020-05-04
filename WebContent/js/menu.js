/** Declaramos variables*/
var showMenu = document.getElementById("show-menu");
var iconoMenu = document.getElementById("icon-menu");
var contenedor = document.getElementById("move-content");
/** Añadimos eventos*/
iconoMenu.addEventListener("click", mostrar_menu);


/** Definimos funciones */
function mostrar_menu () {
	/*toggle: nos agregue o nos elimine la clase*/
	contenedor.classList.toggle('move-container-all');
	showMenu.classList.toggle('show-lateral');
}