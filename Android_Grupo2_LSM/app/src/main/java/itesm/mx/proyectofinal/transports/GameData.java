package itesm.mx.proyectofinal.transports;

/**
 * Created by Martin RB on 26/03/2018.
 *
 *
 *  LSM - descripción_proyecto
 Elaborar una aplicación para Android en la que los usuarios
 puedan aprender mediante un glosario
 y dos juegos interactivos la Lengua de Señas Mexicana,
 de una manera entretenida.

 Copyright (C) 2018 - ITESM

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *
 */

public abstract class GameData {
    protected String tipoJuego = "nop";

    public String getTipoJuego(){
        return tipoJuego;
    }
}
