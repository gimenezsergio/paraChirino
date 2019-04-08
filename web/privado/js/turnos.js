class Turnos {
    static alta() {
        const traer = async() => {
            let reserva = {};
            reserva.fecha = document.querySelector("#fecha").value;
            let reservaStringJSON = JSON.stringify(reserva);
            let respuesta = await fetch("Reservas",
                    {method: 'POST', body: reservaStringJSON});
            let datotexto = JSON.parse(await respuesta.text());
            //document.querySelector('#turnosReservados').innerHTML = datotexto;
        };
        traer()
                .catch(ex => {
                    document.querySelector("#panelMensajes").innerHTML = 'ERROR: ' + ex.message;
                });
        Turnos.obtener();

    }

    static obtener() {
        const traer = async() => {
            let respuesta = await fetch("Reservas", {method: 'GET'});
            let reservas = JSON.parse(await respuesta.text());
            if (reservas.length < 1 || reservas == undefined) {
                console.log("Sin datos");
                document.querySelector("#turnosReservados").innerHTML = "No hay reservas aun";
            } else {
                let templateReservas = await `
    <table>
            <tr><th>Fecha</th><th>ID</th><th>Accion</th><th>Accion</th></tr>
    ${ reservas.map(reserva =>
                        `
              <tr class='persona_item'>
                  <td><span id='reserva_fecha_${reserva.id}'>${reserva.fecha}<span></td>
                  <td><span id='reserva_id_${reserva.id}'> --- ${reserva.id} ---<span></td>
                  <td><input type='button' value='Modificar' onclick='Persona.actualizar(${reserva.id});' /></td>
                  <td><input type='button' value='Eliminar' onclick='Persona.eliminar(${reserva.id});' /></td>
              </tr>
    `
                ).join('')
                        }
    </table>
`;
                //    document.querySelector('#panelResultados').innerHTML = await eval(templatePersonas);
                document.querySelector("#turnosReservados").innerHTML = templateReservas;
            }
            ;
        }

        traer()
                .catch(ex => {
                    document.querySelector("#panelMensajes").innerHTML = 'ERROR: ' + ex.message;
                });
    }

    static btn() {
        // document.querySelector("#reservarBtn").setAttribute("onclick", "Turnos.alta();");
        // document.querySelector("#consultaBtn").setAttribute("onclick", "Turnos.obtener();");
        // document.querySelector("#logout").setAttribute("onclick", "Log.out();");

    }
    static itemPnl() {
        document.querySelector("#perfilMenuItem").setAttribute("onclick", "Turnos.showPnl('perfilTpl');");
        document.querySelector("#grillasMenuItem").setAttribute("onclick", "Turnos.showPnl('grillasTpl');");
        document.querySelector("#calendarioMenuItem").setAttribute("onclick", "Turnos.showPnl('calendarioTpl');");
        //document.querySelector("#turnosMenuItem").setAttribute("onclick", "Turnos.showPnl('turnosTpl');");
        document.querySelector("#turnosMenuItem").setAttribute("onclick", "Turnos.getTurnos();");
    }

    static getTurnos() {

        const accion = async() => {
            let respuesta = await fetch("../Turnos", {method: 'GET', credentials: "same-origin"});
            let turnos = JSON.parse(await respuesta.text());
            let templateTurnos = await `
            
    ${ turnos.map(turno =>
                    `
            <div class="card">
                <span class="delete-btn">−</span> 
                <div class="date">
                    <h3 class="day">Turno</h3>
                    <p id="time-start">Desde: ${turno.desde}</p>
                    <p id="time-end">Hasta: ${turno.hasta}</p>
                </div>
                <div class="description">
                    <h2 id="grillaId">Grilla: ${turno.grilla}</h2>
                    <p id="pacienteId">Paciente: <strong> ${turno.paciente} </strong></p>
                </div> 
            </div>
    `
            ).join('')
                    }
    
`;
            document.querySelector("#templateString").innerHTML = templateTurnos;
        }
        accion();
        Turnos.showPnl('turnosTpl');
        console.log("fin get turnos");
    }

    static showPnl(panel) {
        let paneles = document.querySelectorAll(".templatePnl");
        console.log("panel: " + panel);
        for (let i = 0; i < paneles.length; i++) {
            console.log(paneles[i]);
            paneles[i].classList.add("hide");
        }
        document.querySelector("#" + panel).classList.remove("hide");
        console.log(paneles);
    }
}

class Log {
    static out() {

        const accion = async() => {
            let respuesta = await fetch("../Logout", {method: 'GET'});

        }
        accion();
    }
}

class Profile{
    static get(){
        const accion = async() => {
            let respuesta = await fetch("../Profile", {method: 'GET', credentials: "same-origin"});
            let profile = JSON.parse(await respuesta.text());
            document.querySelector("#nombreUserAside").innerHTML = profile.username;
            document.querySelector("#emailUserProfile").innerHTML = profile.email;
            document.querySelector("#nombreUserProfile").innerHTML = profile.username;
            
            
        }
        accion();
        
    }
}

Turnos.btn();
Turnos.itemPnl();
Profile.get();