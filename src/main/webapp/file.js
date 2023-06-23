

var socket = new WebSocket("ws://localhost:8080/myApp/WebSocketServer");
 socket.onmessage = function(event) {
     var chemins = JSON.parse(event.data);
     length=chemins.length;
     

 am5.ready(function() {
	
    
    
    // Create root element
    // https://www.amcharts.com/docs/v5/getting-started/#Root_element
    var root = am5.Root.new("chartdiv");
     
    // Set themes
    // https://www.amcharts.com/docs/v5/concepts/themes/
    root.setThemes([
      am5themes_Animated.new(root)
    ]);
    
   
    //root.container.children.push adds the map chart to the container within the root element. am5map.MapChart.new creates a new map chart instance.
    var chart = root.container.children.push(am5map.MapChart.new(root, {
      panX: "rotateX",  //panX: "rotateX" enables horizontal panning of the chart by rotating it along the X-axis.
      panY: "translateY",//panY: "translateY" enables vertical panning of the chart by translating it along the Y-axis.
      projection: am5map.geoMercator(), //projection: am5map.geoMercator() sets the map projection to Mercator, which is a common projection for world maps.
      homeGeoPoint: { latitude: 262, longitude: 2 } //homeGeoPoint: { latitude: 2, longitude: 2 } defines the initial center point of the map at latitude 2 and longitude 2.
    }
    ));
  

    var cont = chart.children.push(am5.Container.new(root, {
      layout: root.horizontalLayout,
      x: 20,
      y: 40
    }));
        
    // Add labels and controls

    
    cont.children.push(am5.Label.new(root, {
      centerY: am5.p50,
      text: "Map"
    }));
    


    
    var switchButton = cont.children.push(am5.Button.new(root, {
      themeTags: ["switch"],
      centerY: am5.p50,
      icon: am5.Circle.new(root, {
        themeTags: ["icon"]
      })
    }));
    
    switchButton.on("active", function() {
      if (!switchButton.get("active")) {
        chart.set("projection", am5map.geoMercator());
        chart.set("panY", "translateY");
        chart.set("rotationY", 0);
        backgroundSeries.mapPolygons.template.set("fillOpacity", 0);
      } else {
        chart.set("projection", am5map.geoOrthographic());
        chart.set("panY", "rotateY")
    
        backgroundSeries.mapPolygons.template.set("fillOpacity", 0.1);
      }
    });
    
    cont.children.push(
      am5.Label.new(root, {
        centerY: am5.p50,
        text: "Globe"
      })
    );
    
    // Create series for background fill
    // https://www.amcharts.com/docs/v5/charts/map-chart/map-polygon-series/#Background_polygon
    
    
    
    
    
    
 /*    var backgroundSeries = chart.series.push(am5map.MapPolygonSeries.new(root, {}));
    backgroundSeries.mapPolygons.template.setAll({
      fill: root.interfaceColors.get("alternativeBackground"),
      fillOpacity: 0,
      strokeOpacity: 0
    });*/
   
     
     var backgroundSeries = chart.series.push(am5map.MapPolygonSeries.new(root, {}));
    backgroundSeries.mapPolygons.template.setAll({
      fill: "#454545",
      fillOpacity: 0,
      strokeOpacity: 0
    });
 
   
   
  
      
   
   
   
   
   
    // Add background polygon
    // *https://www.amcharts.com/docs/v5/charts/map-chart/map-polygon-series/#Background_polygon




    backgroundSeries.data.push({
      geometry: am5map.getGeoRectangle(90, 180, -90, -180)
    });
    





    // Create main polygon series for countries
    // https://www.amcharts.com/docs/v5/charts/map-chart/map-polygon-series/
    var polygonSeries = chart.series.push(am5map.MapPolygonSeries.new(root, {
      geoJSON: am5geodata_worldLow
    }));
    polygonSeries.mapPolygons.template.setAll({
  fill:  "#6ECCAF",
  fillOpacity: 1, // Adjust the opacity as desired
  strokeOpacity: 1 // Adjust the stroke opacity as desired
});
   /** */ 

   
var lineSeries = chart.series.push(am5map.MapLineSeries.new(root, {}));
lineSeries.mapLines.template.setAll({
  stroke: root.interfaceColors.get("alternativeBackground"),
  strokeOpacity: 0.3
});




var pointSeries = chart.series.push(am5map.MapPointSeries.new(root, {}));
var colorset = am5.ColorSet.new(root, {});

var temperature = Math.round(Math.random() * 10 + 10); // random temperature between 20 and 30
var pressure = Math.round(Math.random() * 100 + 1013); // random pressure between 1013 and 1113
var list = ["temperature: " + temperature, "pressure: " + pressure];


var circleRadius;
 
pointSeries.bullets.push(function() {
   container = am5.Container.new(root, {
    tooltipText: "",
    cursorOverStyle: "pointer"
  });

  container.events.on("click", (e) => {
    window.location.href = e.target.dataItem.dataContext.url;
  });


 var circle1 = container.children.push(
    am5.Circle.new(root, {
      radius: 10,
      tooltipY: 0,
     /* fill: colorset.next(),*/
     fill:"#FF0000",
      strokeOpacity: 0
    })
  );


console.log("children",container.children);


container.children.push(circle1);

 var circle2 = container.children.push(
    am5.Circle.new(root, {
      radius: 7,
      tooltipY: 0,
      /*fill: colorset.next(), */
      fill: "#FF0000",
      strokeOpacity: 0,
      tooltipText: "" // Initialize tooltipText with an empty string
    })
  );
  /** */
var circle2Radius = circle2.get("radius");
console.log("Rayon du cercle2sssssss :", circle2Radius);
/** */
  function updateTooltipText(circle2, list) {
    circle2.set("tooltipText", list.join("\n"));
  }
/** */




// Utilisez la variable circle1Radius à l'extérieur de la fonction
//console.log("Rayon du cercle1 :", circle1Radius);











/** */

function generateRandomData() {
  var temperature = Math.round(Math.random() * 10 + 10);
  var pressure = Math.round(Math.random() * 100 + 1013);
  var list = ["temperature: " + temperature, "pressure: " + pressure];
  return list;
}
 function ajaxFunction(plane,carburant) {
            // Créez un nouvel objet XMLHttpRequest
        
            
            
            var xhttp = new XMLHttpRequest();

            // Définissez la fonction de rappel pour la réponse AJAX
            xhttp.onreadystatechange = function() {
                if (this.readyState === 4 && this.status === 200) {
                    // Traitement de la réponse
                    console.log(this.responseText);
                         
                    
                }
            };
       
            // Effectuez une requête GET AJAX avec le paramètre
             xhttp.open("GET", "http://localhost:8080/myApp/index.jsp?list=" + list, true); 
            xhttp.send();
            console.log("Le list est " + list);
            
           updateTooltipText(circle2, list);
   
        }




          

 
function changeParamPeriodically(circle2) {
  setInterval(function() {
    var list = generateRandomData();
    updateTooltipText(circle2, list);
  }, 500); // Execute every 100 seconds (100,000 milliseconds)
}

  changeParamPeriodically(circle2);


  circle1.animate({
    key: "scale",
    from: 1,
    to: 5,
    duration: 600,
    easing: am5.ease.out(am5.ease.cubic),
    loops: Infinity
  });
  

  circle1.animate({
    key: "opacity",
    from: 1,
    to: 0.1,
    duration: 600,
    easing: am5.ease.out(am5.ease.cubic),
    loops: Infinity
  });

  return am5.Bullet.new(root, {
    sprite: container
  });
});






var cities = [
  
  {
    title: "Copenhagen",
    latitude: 55.6763,
    longitude: 12.5681,
    url: "http://www.amcharts.com"
  },
 
  {
    title: "Reykjavik",
    latitude: 64.1353,
    longitude: -21.8952,
    url: "http://www.amcharts.com"
  },
  {
    title: "Moscow",
    latitude: 55.7558,
    longitude: 37.6176,
    url: "http://www.amcharts.com"
  }
  ,
  {
    title: "Tokyo",
    latitude: 35.6785,
    longitude: 139.6823,
    url: "http://www.amcharts.com"
  },
  {
    title: "Ankara",
    latitude: 39.9439,
    longitude: 32.856,
    url: "http://www.amcharts.com"
  }
 
];


var kn=0;


for (var i = 0; i < cities.length; i++) {
  kn=i+1;
  var city = cities[i];

  addCity2(city.longitude, city.latitude, city.title, city.url);
  
}


//console.log(container.children);




function addCity2(longitude, latitude, title, url) {
  pointSeries.data.push({
    url: url,
    geometry: { type: "Point", coordinates: [longitude, latitude] },
    title: title
    
  });
}

  



    /** */
 
 


    /** */
    
    
    
   /** */
 var ns=0;
  console.log("bulletsss", pointSeries.bullets);
 
  var points= pointSeries.data.values;

      for(var t=0;t<length-12;t++){
	   
  
 var latitudes = [];
 var longitudes = [];
for (var i = 0; i < points.length; i++) {
	
  var point = points[i];
  var latitude = point.geometry.coordinates[1];
  var longitude = point.geometry.coordinates[0];
  
  latitudes.push(latitude);
  longitudes.push(longitude);
}
   // console.log("*************les points: ",points);
   // console.log("*************les points)))))): ");
  // console.log("*************containers: ",container.children[0].radius);
    
    
	   var lineSeries = chart.series.push(am5map.MapLineSeries.new(root, {}));
	   
    lineSeries.mapLines.template.setAll({
      stroke: root.interfaceColors.get("alternativeBackground"),
      strokeOpacity: 0.3
    });
    
    // Create point series for markers
    // https://www.amcharts.com/docs/v5/charts/map-chart/map-point-series/
    var pointSeries = chart.series.push(am5map.MapPointSeries.new(root, {}));  
    
    var k=0;
    var m=0;
    var x=0;
      
    pointSeries.bullets.push(function() {
      var circle = am5.Circle.new(root, {
        radius: 7,
        tooltipText: "Drag me!",
        cursorOverStyle: "pointer",
        tooltipY: 0,
        fill: am5.color(0xffba00),
        stroke: root.interfaceColors.get("background"),
        strokeWidth: 2,
        draggable: true
      });      
   


      var pistedeparts=chemins[length-11];
    lenpistedep=pistedeparts.length;
    var pistearrivees=chemins[length-10];
    
    
    var placesausoldepart=chemins[length-9];
    var placesausolarriv=chemins[length-8];
    
    
    
    var Attenteausoldepart=chemins[length-7];
    var Attenteausolarrivee=chemins[length-6];
    var Accespistedepart=chemins[length-5];
    var Accespistearrivee=chemins[length-4];
    var anticollisiondepart=chemins[length-3];
    var anticollisionarrive=chemins[length-2];
     
     k=k+1;
     
   console.log("depart:"+pistedeparts+"les x"+x);
   console.log("depart:"+pistearrivees+"les x"+x);
   
    var tooltipTextArray = [
      ["Pistes vides         : "+pistedeparts[x], "Places au sol    : "+placesausoldepart[x], "Attente au sol   : "+Attenteausoldepart[x],"Acces au piste   : "+Accespistedepart[x],"AntiCollision   : "+anticollisiondepart[x]],
       ["Pistes vides         : "+pistearrivees[x], "Places au sol    : "+placesausolarriv[x], "Attente au sol   : "+Attenteausolarrivee[x],"Acces au piste   :"+Accespistearrivee[x],"AntiCollision   : "+anticollisionarrive[x]]
  
      // Ajoutez d'autres tableaux pour chaque point
    ];
    

    
    
// circle.set("tooltipText", tooltipTextArray[k].join("\n"));


  circle.set("tooltipText", tooltipTextArray[m].join("\n"));

   if(k!=2){
	
	
	m=m+1;
	
}
else{
	 m=0;
	k=0;
} 
     if(x<lenpistedep-1 && m==0)   {
	 x++;
 }
    
    
        
     circle.events.on("dragged", function(event) {
        var dataItem = event.target.dataItem;
        var projection = chart.get("projection");
        var geoPoint = chart.invert({ x: circle.x(), y: circle.y() });
    
        dataItem.setAll({
          longitude: geoPoint.longitude,
          latitude: geoPoint.latitude
        });
      });
    
      return am5.Bullet.new(root, {
        sprite: circle
      });
    });
    
    



     var myArray = [];
     var dict21=chemins[t];
 console.log("result",dict21);
 console.log(length);
 console.log(t);
 
  //C E
  
    for (var city of Object.keys(dict21)) {
  
    var coordinates = dict21[city];
    var latitude = coordinates[0];
    var longitude = coordinates[1];
    
    var result = addCity({ latitude, longitude }, city);
    console.log(result);
   myArray.push(result);
  }
  
  
    
    
    
    
   
    
    var lineDataItem = lineSeries.pushDataItem({
      pointsToConnect: myArray
    });       
     
      var planeSeries = chart.series.push(am5map.MapPointSeries.new(root, {}));
      
      console.log("nes c'est: ",t);
      
      
    // var valuet=1500;
    var capacites=chemins[length-1];
     var arrivees=chemins[length-12];
   /* var consom=chemins[length-1];*/
    
    var valuet=1200;
    
    console.log("les capacites sont",capacites[t]);
    
    var plane=null; 
    var planes=[];
    
 planeSeries.bullets.push(function() {
      var container = am5.Container.new(root, {});
      //
      
        plane = am5.Graphics.new(root, {
		 tooltipText: "Carburant:"+  valuet ,
        cursorOverStyle: "pointer",
      svgPath:
        "m2,106h28l24,30h72l-44,-133h35l80,132h98c21,0 21,34 0,34l-98,0 -80,134h-35l43,-133h-71l-24,30h-28l15,-47",
      scale: 0.06,
      centerY: am5.p50,
      centerX: am5.p50,
      /*fill: am5.color(0x000000)*/
      fill:"#FFE569"
    });
      planes.push(plane);
      //
      container.children.push(plane);
      return am5.Bullet.new(root, { sprite: container });
    });  
    
    
 /* var destination=	;   */
    
    
 // Fonction pour mettre à jour le tooltip text
   function updateTooltipText(plane,valuet,arrivee) {
	
     
      plane.set("tooltipText", "Carburant: " + valuet + '\nDestination: ' + arrivee);

  
}


/** */




  var intervalId;

    // Fonction AJAX pour afficher le carburant à chaque étape
        function ajaxFunction(plane,carburant,arrive) {
            // Créez un nouvel objet XMLHttpRequest
            if (planeDataItem && planeDataItem.get("positionOnLine") >= 1) {
    // Arrêtez l'appel AJAX en utilisant clearInterval
    clearInterval(intervalId);
    return;
  }
            
            
            var xhttp = new XMLHttpRequest();

            // Définissez la fonction de rappel pour la réponse AJAX
            xhttp.onreadystatechange = function() {
                if (this.readyState === 4 && this.status === 200) {
                    // Traitement de la réponse
                    console.log(this.responseText);
                         
                    
                }
            };
       
            // Effectuez une requête GET AJAX avec le paramètre
           // xhttp.open("GET", "http://localhost:8080/myApp/index.jsp?carburant=" + carburant, true);
           xhttp.open("GET", "http://localhost:8080/myApp/index.jsp?carburant=" + carburant + "&arrive=" + arrive, true);

            xhttp.send();
            console.log("Le carburant est " + carburant);
            
           updateTooltipText(plane,carburant,arrive);
   
        }
         
        // Fonction pour changer le paramètre périodiquement
        function changeParamPeriodically() {
			
            var carburant = capacites.slice();  // Paramètre initial
            
            // Utilisez setInterval pour exécuter une fonction toutes les secondes
            setInterval(function() {
                // décrémentez le paramètre
                 carburant = carburant.map(function(value) {
					
                       return value -10;
                                                          });
                                                          
               // carburant = carburant - 20;
                
                for(var i=0;i<planes.length;i++){
					var plane=planes[i];
					  var currentCarburant = carburant[i];
					  var arrive=arrivees[i];
					console.log("lengthhh",planes.length-1);
                // Appelez la fonction AJAX avec le nouveau paramètre
                ajaxFunction(plane,currentCarburant,arrive);
                // Vérifier la distance entre l'avion et circle1
              
             }
            
            } , 1000); // Exécutez toutes les secondes (1000 millisecondes)
            
        }

        // Appelez la fonction pour commencer le changement périodique du paramètre
        
    
   changeParamPeriodically();
    
    
      
       var planeDataItem = planeSeries.pushDataItem({
      lineDataItem: lineDataItem,
      positionOnLine: 0,
      autoRotate: true
    });
    
    planeDataItem.dataContext = {};
    

/** plane vitesse */

    /** */
let animationInProgress1 = true;

  planeDataItem.animate({
  key: "positionOnLine",
  to: 1,
  duration: 40000,
  easing: am5.ease.linear,
  events: {
    onanimationended: function() {
      if (animationInProgress1) {
        plane.set("rotation", 0); // Définir la rotation du plane à 0 degrés à son point d'arrivée
         
        animationInProgress1 = false;
      }
    }
  }
});

/** */



// Assuming you have the coordinates of the plane as planeLongitude and planeLatitude




/** */

planeDataItem.on("positionOnLine", (value) => {
	console.log(value);
console.log("latitudesssss",planeDataItem.get("latitude", value));


	//console.log("circlecest",circle1);
  if (value >= 1 && animationInProgress1) {
    planeDataItem.animate({ key: "positionOnLine", to: 1, duration: 0 });
  }
   else {
	   
	   
	   
	   
    if (planeDataItem.dataContext.prevPosition < value) {
      plane.set("rotation", 0);
    }

    if (planeDataItem.dataContext.prevPosition > value) {
      plane.set("rotation", -180);
    }
  }
  planeDataItem.dataContext.prevPosition = value;
  
});


/**  */



/*
planeDataItem.on("positionOnLine", (value) => {
  var circle1Radius = 200;

    for (var i = 0; i < kn; i++) {
		
	    var currentLatitude = latitudes[i];
	    var currentLongitude = longitudes[i];
	   console.log("latitudessssssssssss",currentLatitude);
	
	    var planeLatitude = planeDataItem.get("latitude", value);
	    var planeLongitude = planeDataItem.get("longitude", value);
	    console.log(planeLatitude);
  // Obtain the SVG point of the circle center
    var circlePoint = chart.convert({ latitude: currentLatitude, longitude: currentLongitude });
    var circleX = circlePoint.x;
    var circleY = circlePoint.y;

    // Obtain the SVG point of the plane
    var planePoint = chart.convert({ latitude: planeLatitude, longitude: planeLongitude });
    var planeX = planePoint.x;
    var planeY = planePoint.y;
console.log("x *******",planeX);
	   
var distanceToCircle1InPixels = Math.sqrt(Math.pow(planeX - circleX, 2) + Math.pow(planeY - circleY, 2));


  console.log("distacessss",distanceToCircle1InPixels);
    if (distanceToCircle1InPixels <= circle1Radius) {
      // L'avion se trouve à l'intérieur du cercle1
      planeDataItem.animate({ key: "positionOnLine", to: 1, duration: 0 });
      break; // Sortir de la boucle dès que l'avion est positionné
    } else {
      // L'avion ne se trouve pas à l'intérieur du cercle1
      console.log("L'avion ne se trouve pas à l'intérieur du cercle1");
    }
  }
  
       });*/
























    function addCity(coords, title) {
      return pointSeries.pushDataItem({
        latitude: coords.latitude,
        longitude: coords.longitude
      });
    }
   }


    
    // Make stuff animate on load
   // chart.appear(1000, 100);
   chart.appear(1000, 1000);
    }); // end am5.ready()
    
    
     
    
    };
    
    
	
			    