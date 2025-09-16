drop database if exists DB_ahorcado;
create database DB_ahorcado;
use DB_ahorcado;

create table Usuarios(
	codigo_usuario int auto_increment,
    usuario varchar(50) not null,
    contrasena varchar(100) not null,
    primary key PK_codigoUsuario(codigo_usuario)
);

create table Palabras(
	codigo_palabra int auto_increment,
    palabra varchar(50) not null,
    pista1 varchar(100),
    pista2 varchar(100),
    pista3 varchar(100),
    primary key PK_codigoPalabra(codigo_palabra)
);

Delimiter $$
	create procedure sp_AgregarPalabra(
		in palabra varchar(50),
		in pista1 varchar(100),
		in pista2 varchar(100),
		in pista3 varchar(100))
	begin
		insert into Palabras (palabra, pista1, pista2, pista3)
			values (palabra, pista1, pista2, pista3);
	end $$
Delimiter ;

call sp_AgregarPalabra('GUITARRA', 'Es un instrumento musical de cuerda.', 'Puede ser acústica o eléctrica.', 'Se toca con los dedos o con una púa.');
call sp_AgregarPalabra('TELEFONO', 'Dispositivo utilizado para comunicarse a distancia.', 'Puede ser fijo o móvil.', 'Inventado por Alexander Graham Bell.');
call sp_AgregarPalabra('INTERNET', 'Red global de computadoras interconectadas.', 'Permite el acceso a información y comunicación.', 'Se utiliza para navegar, enviar correos y ver videos.');
call sp_AgregarPalabra('AUTOMOVIL', 'Vehículo de transporte con motor.', 'Generalmente tiene cuatro ruedas.', 'Se conduce con un volante y pedales.');
call sp_AgregarPalabra('Ahorcado', 'Juego dinámico.', 'Debes de adivinar la palabra.', 'Es un muñeco que se va completando.');
call sp_AgregarPalabra('COMPUTADORA', 'Dispositivo electrónico de procesamiento de datos.', 'Puede ser portátil o de escritorio.', 'Se utiliza para trabajar, estudiar y jugar.');
call sp_AgregarPalabra('LIBRO', 'Objeto que contiene páginas escritas o impresas.', 'Puede ser de papel o digital.', 'Se utiliza para leer y aprender.');
call sp_AgregarPalabra('RELOJ', 'Instrumento que mide el tiempo.', 'Puede ser de pulsera o de pared.', 'Indica horas, minutos y segundos.');
call sp_AgregarPalabra('AVION', 'Medio de transporte aéreo.', 'Tiene alas y motores.', 'Se utiliza para viajes largos y rápidos.');
call sp_AgregarPalabra('SOL', 'Estrella que ilumina la Tierra.', 'Es esencial para la vida.', 'Proporciona luz y calor.');


Delimiter $$
	create procedure sp_ListarPalabras()
		begin
			select palabra, pista1, pista2, pista3
			from Palabras;
		end $$
Delimiter ;

call sp_ListarPalabras();

Delimiter $$
	create procedure sp_PalabraAleatoria()
		begin
			select palabra, pista1, pista2, pista3
			from Palabras order by rand() limit 1;
		end $$
Delimiter ;
call sp_PalabraAleatoria();


Delimiter $$
	create procedure sp_AgregarUsuario(
		in usuario varchar(50),
		in contraseña varchar(100))
	begin
		insert into Usuarios (usuario, contrasena)
			values (usuario, contrasena);
	end $$
Delimiter ;

call sp_AgregarUsuario('Adrian','2024004');
call sp_AgregarUsuario('Beatriz','2024005');
call sp_AgregarUsuario('Carlos','2024006');
call sp_AgregarUsuario('Daniela','2024007');
call sp_AgregarUsuario('Eduardo','2024008');
call sp_AgregarUsuario('Fernanda','2024009');
call sp_AgregarUsuario('Gabriel','2024010');
call sp_AgregarUsuario('Helena','2024011');
call sp_AgregarUsuario('Ignacio','2024012');
call sp_AgregarUsuario('Julieta','2024013');

Delimiter $$
	create procedure sp_ValidarUsuario(
		in p_usuario varchar(50),
		in p_contrasena varchar(100))
	begin
		select  * from Usuarios
			where usuario = p_usuario AND contrasena = p_contrasena;
	end $$
Delimiter ;

select * from Usuarios;
select * from Palabras;
call sp_ValidarUsuario('Adrian','2024004');