<!DOCTYPE html>
<html>

<head>
  <!-- Basic -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />

  <title>
    TripBiz
  </title>

  <!-- range selctor slider style -->


  <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ion-rangeslider/2.3.0/cssvol/ion.rangeSlider.min.css" /> -->
  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="cssvol/bootstrap.css" />
  <!-- fonts style -->
  <link href="https://fonts.googleapis.com/css?family=Poppins:400,600,700&display=swap" rel="stylesheet" />
  <!-- Custom styles for this template -->
  <link href="cssvol/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="cssvol/responsive.css" rel="stylesheet" />

  <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;700&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">


  <style>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

html, body {
height: 100vh;
/* background-image: url("img/foant.png"); */
font-family: 'Balsamiq Sans', sans-serif;
background-color:blue;
}

body {
/* display: flex; */
align-items: center;
justify-content: center;
}


header {
  height: 100vh;
  position: relative;
}


.nav-area {
  height: 60px;
  position: absolute;
  width: 100%;
  padding-top: 10px;
  padding-bottom: 10px;
  background-color: #344578;
}
.logo {
  margin: 0px 50px;
  font-size: 5em;
  font-weight: 800;
  height: 60px;
  float: left;
  color: #fff;
  font-size: 35px;
  text-transform: capitalize;
}
.menu-area {
  float: right;
  list-style: none;
  margin: 20px;
}
.menu-area li {
  display: inline-block;
  margin: 0 5px;
}
.menu-area li a {
  text-decoration: none;
  color: #fff;
  padding: 5px 10px;
  letter-spacing: 2px;
  font-weight: 700;
}
.menu-area li a:hover {
  color: rgb(0, 85, 255);
}
header .welcome-text {
  position: absolute;
  width: 100%;
  /* text-align: center; */
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}
.welcome-text h2 {
  color: #461bba;
  font-size: 100px;
  margin: 0;
  font-family: 'Bebas Neue', sans-serif;
  /* -webkit-text-fill-color: transparent; */
  -webkit-text-stroke: 1px #aca8c3;
}


@media (max-width: 767px) {
  .logo {
      float: none;
      text-align: center;
      margin: 5px 0;
      font-size: 23px;
      height: 45px;
      line-height: 45px;
  }
  .menu-area {
      float: none;
      text-align: center;
      margin: 0;
  }
  .menu-area li {
      margin: 0;
  }
  .menu-area li a {
      padding: 5px 2px;
      font-size: 12px;
  }
  
  .nav-area {
      height: 90px;
  }
  .welcome-text h2 {
      font-size: 40px;
      margin-bottom: 18px;
      -webkit-text-stroke: 1px #fff;
  }
  .welcome-text p {
      width: 90%;
      font-size: 14px;
      line-height: 1.5;
  }
}


  </style>

</head>

<body>

 <%@ page import="java.sql.*" %>
    <%@ page import="java.util.*" %>

    <%
    // Establish a database connection
    String url = "jdbc:mysql://localhost:3304/simulator";
    String username = "root";
    String password = "";
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection(url, username, password);

    // Fetch airports from the database
    List<String> departureAirports = new ArrayList<>();
    List<String> arrivalAirports = new ArrayList<>();
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM aeroport");
    while (rs.next()) {
        String name = rs.getString("nom");
        departureAirports.add(name);
        arrivalAirports.add(name);
    }
    rs.close();
    stmt.close();

    // Fetch aircraft from the database
    List<String> aircrafts = new ArrayList<>();
    stmt = conn.createStatement();
    rs = stmt.executeQuery("SELECT * FROM avion");
    while (rs.next()) {
        String idavion = rs.getString("idavion");
        aircrafts.add(idavion);
    }
    rs.close();
    stmt.close();
    conn.close();
    %>


  
    <!-- header section strats -->
    <header class="header_section">
        
            <!-- <video src="videos/flight4.mp4" class="vid-bg" autoplay loop muted></video> 
            <div class="overlay"></div> -->
            <div class="nav-area">
                <div class="logo" >ATC</div>
    
                <ul class="menu-area">
                   <li><a href="home.html">Home</a></li>
                <li><a href="airoport.jsp">Aeroports</a></li>
                <li><a href="vol.jsp">volCreation</a></li>
                <li><a href="index.jsp">simulation</a></li>
                 <li><a href="affichevol.jsp">Vols</a></li>
                </ul>
            </div>
    
    <!-- end header section -->
    <!-- slider section -->
  </div>

  <!-- trip section -->

  <section class="trip_section layout_padding" id="bookTrip">
    
    <div class="container ">
      <div class="box container-bg">
        <div class="img-box">
          <img src="image/form-img.png" alt="">
        </div>
        
        
        
        <div class="form_container">
          <form method="post" action="table.jsp">
            
            
            <div class="form-group ">
              <div class="input-group ">
                <div class="input-group-prepend">
                  <div class="input-group-text">
                    <img src="image/location.png" alt="">
                  </div>
                </div>
                  <select  id="inputLanguage" class="form-control" id="departureAirport" name="departureAirport">
            <% for (String airport : departureAirports) { %>
                <option value="<%= airport %>"><%= airport %></option>
            <% } %>
        </select>
                <div class="input-group-append">
                  <div class="input-group-text">
                    <img src="image/down-arrow.png" alt="">
                  </div>
                </div>
              </div>
              <div class="select_arrow"></div>
            </div>
            
            
            
            <div class="form-group ">
              <div class="input-group ">
                <div class="input-group-prepend">
                  <div class="input-group-text">
                    <img src="image/location.png" alt="">
                  </div>
                </div>
                 <select  id="inputLanguage" class="form-control" id="arrivalAirport" name="arrivalAirport">
            <% for (String airport : arrivalAirports) { %>
                <option value="<%= airport %>"><%= airport %></option>
            <% } %>
        </select>
                <div class="input-group-append">
                  <div class="input-group-text">
                    <img src="image/down-arrow.png" alt="">
                  </div>
                </div>
              </div>
              <div class="select_arrow"></div>
            </div>
            
            
            
            
            
            
            <div class="form-group">
              <div class="input-group ">
                <div class="input-group-prepend">
                  <div class="input-group-text">
                    <img src="image/location.png" alt="">
                  </div>
                </div>
                <input type="number" id="departureTime" name="departureTime" placeholder="HH:MM" class="form-control">
              </div>
            </div>
            
            <div class="form-group">
              <div class="input-group ">
                <div class="input-group-prepend">
                  <div class="input-group-text">
                    <img src="image/location.png" alt="">
                  </div>
                </div>
                <input type="number" id="arrivalTime" name="arrivalTime" placeholder="HH:MM" class="form-control"  >
              </div>
            </div>
            
            
             <div class="form-group">
              <div class="input-group ">
                <div class="input-group-prepend">
                  <div class="input-group-text">
                    <img src="image/location.png" alt="">
                  </div>
                </div>
                <input type="number" id="altitude" name="altitude" placeholder="Altitude" class="form-control" >
              </div>
            </div>
            
            
            <div class="form-group ">
              <div class="input-group ">
                <div class="input-group-prepend">
                  <div class="input-group-text">
                    <img src="image/language.png" alt="">
                  </div>
                </div>
               <select   class="form-control" id="aircraft" name="aircraft">
            <% for (String idavion : aircrafts) { %>
                <option value="<%= idavion %>"><%= idavion %></option>
            <% } %>
        </select>
                <div class="input-group-append">
                  <div class="input-group-text">
                    <img src="image/down-arrow.png" alt="">
                  </div>
                </div>
              </div>
              <div class="select_arrow"></div>
            </div>
            
            <div class="btn-box">
              <button type="submit" class="">create vol</button>
            </div>

          </form>

        </div>

        
      </div>

      
    </div>
  </section>

  <!-- end trip section -->
  
        
      <!-- footer section -->
      <section class=" footer_section">
        <p>
          Copyright &copy; 2023 All Rights Reserved By
          IKSO
        </p>
      </section>
      <!-- footer section -->


</body>

</html>