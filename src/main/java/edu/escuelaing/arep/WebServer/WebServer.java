// package edu.escuelaing.arep.WebServer;


// import static spark.Spark.get;
// import static spark.Spark.port;
// import static spark.Spark.post;
// import static spark.Spark.staticFiles;


// import com.google.gson.Gson;



// public  class WebServer {
//     static db db;
//     public static void main(String[] args) {
//         db = new db();
        
//         staticFiles.location("/paginas");
//         Gson gson = new Gson();
//         port(getPort());
//         get("/parcial", (request, response) -> {
//             response.redirect("/index.html");
//             response.status(200);
            
//             return null;
//         });
        


//         post("/parcial/calcular/", (req, res) -> {
//             //res.type("application/json");
//             //res.status(201);
//             System.out.println("peticion");
//             // Double[] ordenados = calc.Ordenar(req.body());
//             // Double sum = calc.sumatoria(ordenados);
//             // String resp = respuesta(ordenados,sum);
//             // System.out.println(resp);
//             // return gson.toJson(resp);
//             return null;
            
//         });
//         }
        
//         private static String respuesta(Double[] ordenados, Double sum) {
//         String ord ="[";
//         for (int i=0; i<ordenados.length;i++){
//             if(!(i==ordenados.length-1)){
//                 ord+=String.valueOf(ordenados[i])+",";
//             }
//             else{ ord+=String.valueOf(ordenados[i]);}
//         }
//         ord+="]";
//         System.out.println(ord);
        
//         String suma = String.valueOf(sum);
//         String res ="{\"DatosOrdenados\":"+ord+",\"Sumatoria\":"+suma+"}";
//         return res;

//     }

//     static int getPort() {
//         if (System.getenv("PORT") != null) {
//         return Integer.parseInt(System.getenv("PORT"));
//         }
//         return 4567; //returns default port if heroku-port isn't set
//         }
    
// }

