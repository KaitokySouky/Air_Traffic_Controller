
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Airport Information</title>

    
    <style>
        * {
          box-sizing: border-box;
          margin: 0;
          padding: 0;
        }
        
        html, body {
        height: 40vh;
        /* background-image: url("img/foant.png"); */
        font-family: 'Balsamiq Sans', sans-serif;
        }
        
        body {
        /* display: flex; */
        align-items: center;
        justify-content: center;
        }
        
        
        header {
          height: 30vh;
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
          align-items: center;
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

        .footer_section {
  margin-top: 45px;
  font-weight: 500;
  align-items: center;
}



        .footer_section p {
  padding: 20px 0;
  margin: 0 auto;
  color: #343030;
  text-align: center;
  border-top: 1.2px solid #4b4c4c;
  width: 75%;
}
        
/*
********************************************/

article {
  --img-scale: 1.001;
  --title-color: black;
  --link-icon-translate: -20px;
  --link-icon-opacity: 0;
  position: relative;
  border-radius: 16px;
  box-shadow: none;
  background: #fff;
  transform-origin: center;
  transition: all 0.4s ease-in-out;
  overflow: hidden;
}

article a::after {
  position: absolute;
  inset-block: 0;
  inset-inline: 0;
  cursor: pointer;
  content: "";
}

/* basic article elements styling */
article h2 {
  margin: 0 0 18px 0;
  font-family: "Bebas Neue", cursive;
  font-size: 1.9rem;
  letter-spacing: 0.06em;
  color: var(--title-color);
  transition: color 0.3s ease-out;
}

figure {
  margin: 0;
  padding: 0;
  aspect-ratio: 16 / 9;
  overflow: hidden;
}

article img {
  max-width: 100%;
  transform-origin: center;
  transform: scale(var(--img-scale));
  transition: transform 0.4s ease-in-out;
}

.article-body {
  padding: 24px;
}

article a {
  display: inline-flex;
  align-items: center;
  text-decoration: none;
  color: #28666e;
}

article a:focus {
  outline: 1px dotted #28666e;
}

article a .icon {
  min-width: 24px;
  width: 24px;
  height: 24px;
  margin-left: 5px;
  transform: translateX(var(--link-icon-translate));
  opacity: var(--link-icon-opacity);
  transition: all 0.3s;
}

/* using the has() relational pseudo selector to update our custom properties */
article:has(:hover, :focus) {
  --img-scale: 1.1;
  --title-color: #28666e;
  --link-icon-translate: 0;
  --link-icon-opacity: 1;
  box-shadow: rgba(0, 0, 0, 0.16) 0px 10px 36px 0px, rgba(0, 0, 0, 0.06) 0px 0px 0px 1px;
}



*,
*::before,
*::after {
  box-sizing: border-box;
}

body {
  margin: 0;
  /* padding: 48px 0; */
  font-family: "Figtree", sans-serif;
  font-size: 1.2rem;
  line-height: 1.6rem;
  background-color: #0b1739;
  min-height: 100vh;
}

.articles {
  display: grid;
  max-width: 1200px;
  margin-inline: auto;
  padding-inline: 24px;
  grid-template-columns: repeat(auto-fill, minmax(320px, 1fr));
  gap: 24px;
}

@media screen and (max-width: 960px) {
  article {
    container: card/inline-size;
  }
  .article-body p {
    display: none;
  }
}

@container card (min-width: 380px) {
  .article-wrapper {
    display: grid;
    grid-template-columns: 100px 1fr;
    gap: 16px;
  }
  .article-body {
    padding-left: 0;
  }
  figure {
    width: 100%;
    height: 100%;
    overflow: hidden;
  }
  figure img {
    height: 100%;
    aspect-ratio: 1;
    object-fit: cover;
  }
}

.sr-only:not(:focus):not(:active) {
  clip: rect(0 0 0 0); 
  clip-path: inset(50%);
  height: 1px;
  overflow: hidden;
  position: absolute;
  white-space: nowrap; 
  width: 1px;
}

h2 {
  font-size:1em; 
  font-weight: 300;
  text-align: center;
  display: block;
  line-height:1em;
  padding-top: 0.4em;
  color: #FB667A;
}

h2 a {
  font-weight: 700;
  text-transform: uppercase;
  color: #FB667A;
  text-decoration: none;
}


</style>

</head>
<body>

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
    
    <div class="welcome-text"> <h2>Aeroports</h2></div>
 </header>
 


 <%@ page import="java.sql.DriverManager" %>
  <%@ page import="java.sql.Connection" %>
   <%@ page import="java.sql.PreparedStatement" %>
    <%@ page import="java.sql.ResultSet" %>
    <%@ page import="java.util.*" %>




<section class="articles">
    

            






    <%
    String url = "jdbc:mysql://localhost:3304/simulator";
    String user = "root";
    String pwd = "";
    int number = 0;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pwd);
        PreparedStatement pst = con.prepareStatement("SELECT * FROM aeroport");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            int aeroportId = rs.getInt("idaeroport");
            String avions = "";

            PreparedStatement pstAvion = con.prepareStatement("SELECT type FROM avion WHERE aeroport = ?");
            pstAvion.setInt(1, aeroportId);
            ResultSet rsAvion = pstAvion.executeQuery();
            while (rsAvion.next()) {
                avions += rsAvion.getString("type") + ", ";
            }
            rsAvion.close();
            pstAvion.close();

            // Remove the trailing comma and space
            if (avions.length() > 0) {
                avions = avions.substring(0, avions.length() - 2);
            }
            %>
            
<article>
      <div class="article-wrapper">
        <figure>
          <img src="airport_images/pic<%=aeroportId%>.jpg" alt="" />
        </figure>
        <div class="article-body">
        
            <h1 style="color:#4942E4;"><%= rs.getString("nom") %></h1>
            
                <p style="color:#11009E;">ID : <%= rs.getInt("idaeroport") %></p>
                 
                <p style="color:#11009E;">Localisation: <%= rs.getString("localisation") %></p>
                
                <p style="color:#11009E;">Nombre de pistes: <%= rs.getInt("nbrePiste") %></p>
                <p style="color:#11009E;">Nombre de sol: <%= rs.getInt("nbreSol") %></p>
                <p style="color:#11009E;">AttenteAuSol: <%= rs.getInt("attenteAuSol") %></p>
               
                <p style="color:#11009E;">type avion: <%= avions %></p>
             </div>
        </div>
        </article>
            
            <%
        }
        rs.close();
        pst.close();
        con.close();
    } catch (Exception e) {
        System.out.print(e);
    }
    %>


       
    </section>
    <!-- end header section -->
    <!-- slider section -->
    </div>
    
       
          <!-- footer section -->
          <section class=" footer_section">
            <p>
              Copyright &copy; 2023 All Rights Reserved By
              IKSO
            </p>
          </section>
</body>
</html>
