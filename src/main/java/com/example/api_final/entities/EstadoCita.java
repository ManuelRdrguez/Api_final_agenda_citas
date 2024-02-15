package com.example.api_final.entities;

public enum EstadoCita {
	  PENDIENTE,    // Reserva realizada, libro esperando ser recogido
	    CONFIRMADA,   // Reserva confirmada, libro recogido por el usuario
	    CANCELADA,    // Reserva cancelada por el usuario o la biblioteca
	    EXPIRADA,     // Reserva no confirmada y pasó el tiempo límite para recoger
	    COMPLETADA    // Reserva completada, libro devuelto
}
