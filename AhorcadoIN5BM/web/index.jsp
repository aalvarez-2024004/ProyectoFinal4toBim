<%-- 
    Document   : index
    Created on : 2 sept 2025, 08:09:27
    Author     : Adrian Alvarez
--%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login Ahorcado | 2024004</title>
        <link rel="stylesheet" href="Styles/index.css">
    </head>

    <body>
        <video autoplay muted loop id="bg-video">
            <source src="video/GokuMeditando.mp4" type="video/mp4">
        </video>

        <div class="login-contendor">
            <h2>Bienvenido</h2>
            <p>Ingresa tus datos para poder iniciar sesion</p>

            <form action="validacion" method="POST">
                <input type="text" name="txtUsuario" placeholder="Usuario" required />
                <input type="password" name="txtContrasena" placeholder="Contraseña" required />
                <button type="submit" name="accion" value="Ingresar">Iniciar Sesión</button>
            </form>
        </div>
    </body>
</html>
