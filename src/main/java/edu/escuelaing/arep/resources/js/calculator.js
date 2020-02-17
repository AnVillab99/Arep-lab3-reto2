
calculator = (function () {
    var datos;

    return {

        ponerDatos: function (datos2) {
            var dat = JSON.parse(datos2);
        },
        obtenerDatos: function () {     
            console.log("pdiendo") ;
            calculadora.getResultadosR('/reto2/usuarios',null, calculator.ponerDatos);     
        }
    };  
})();
calculadora = (function () {
    return {      
        getResultadosR: function (url,datas, callback) {
            console.log("pidiendo ajax");
        $.ajax({
            url: url,
            data: datas,
            type: 'POST',
            dataType: 'json',
            contentType: 'application/javascript',
            success: function(data){
                console.log(data);
                callback(data);
            },
            error: function(data){
                console.log("error: "+JSON.stringify(datas));
            },
        });
        }
    };

})();