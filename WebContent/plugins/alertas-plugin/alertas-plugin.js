$(document).ready(function() {
	/* Variables */
	var tiposDeAlertas = [ {
		"id" : 1,
		"alerta" : "alert-success"
	}, {
		"id" : 2,
		"alerta" : "alert-warning"
	} ]
	var contenedorAlerta = $('#contenedorAlertas');
	var mensajesAlertas = $('#mensajeAlerta');
	// alert alerta-personalizada alert-warning alert-dismissible fade show
	/* FUCIONES */
	function setMensajeAlerta(idTipoAlerta, mensaje) {
		tipoAlerta = tiposDeAlertas.map(function(ta) {return ta.id = idTipoAlerta});
//		 contenedorAlerta.classList.add("alert alerta-personalizada "
//						+ tipoAlerta + " alert-dismissible fade show");
		mensajesAlertas.value = mensaje;
	}

	setMensajeAlerta(1, "mensaje prueba");
});