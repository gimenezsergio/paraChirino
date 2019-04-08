class Access {
    static registerShow(){
        console.log("register");
        
        document.querySelector("#login-userPnl").classList.add("hide");
        document.querySelector("#login-userPnl").classList.remove("show");
        document.querySelector("#register-userPnl").classList.remove("hide");
        document.querySelector("#register-userPnl").classList.add("show");
    }
    
    static registerAlta() {
        const traer = async() => {
            let registro = {};
            registro.user = document.querySelector("#userRegister").value;
            registro.pass = document.querySelector("#passwordRegister").value;
            registro.email = document.querySelector("#emailRegister").value;
            let registroStringJSON = JSON.stringify(registro);
            let respuesta = await fetch("Login",
                    {method: 'POST', body: registroStringJSON});
            let datotexto = JSON.parse(await respuesta.text());
            document.querySelector('#serverMsg').innerHTML = datotexto;
            //Access.loginShow();
        };
        traer()
        .catch(ex => {
            document.querySelector("#serverMsg").innerHTML = 'ERROR: ' + ex.message;
            //Access.registerShow();
         });
    }
    
    static loginShow(){
        document.querySelector("#login-userPnl").classList.add("show");
        document.querySelector("#login-userPnl").classList.remove("hide");
        document.querySelector("#register-userPnl").classList.remove("show");
        document.querySelector("#register-userPnl").classList.add("hide");
    }
    
    static init(){
        document.querySelector("#register-user").setAttribute("onclick", "Access.registerShow();");
        document.querySelector("#login-user").setAttribute("onclick", "Access.loginShow();");
        document.querySelector("#register-userPnl").classList.add("hide");
        document.querySelector("#registerBtn").setAttribute("onclick", "Access.registerAlta();");
        
    }
}
Access.init();