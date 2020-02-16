
calculator = (function () {
    var datos;

    return {
        setDatos: function () {
            datos = document.getElementById("nums").value;
            
        },

        ponerDatos: function (datos2) {
            var dat = JSON.parse(datos2)
            $("#resultados").find("#resultsBody").append(
                "<tr><td>" + dat.DatosOrdenados + "</td><td>" + dat.Sumatoria + "</td></tr>")
        
            
            // var dataJson = JSON.parse(data);
            
        },

        obtenerDatos: function () {           
            calculator.setDatos();
            calculadora.getResultadosR('/parcial/calcular/',datos, calculator.ponerDatos);
            
        }
    };  
})();
calculadora = (function () {

    
    return {      
        getResultadosR: function (url,datas, callback) {

        

        $.ajax({
            url: url,
            data: datas,
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            
            success: function(data){
                console.log(data)
                callback(data);
            },
            error: function(data){
                console.log("error: "+JSON.stringify(datas));
            },
            
        });
/*
        
        $.get( '/calculator/calcular', function( data ) {
        console.log(data);
        
        callback(data);
        
        });*/
        }
    };

})();