create database if not exists `BaseProy`;
use `BaseProy`;

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL auto_increment,
  `nombre` varchar(50) NOT NULL,
  `apellido1` varchar(50) NOT NULL,
  `apellido2` varchar(50) NOT NULL,
  `facultad` varchar(50) NOT NULL,
  `esProfesor` boolean NOT NULL,

  `email` varchar(50) NOT NULL,
  `password` varchar(25) NOT NULL,
  
  `rfc` varchar(13) NULL,
  `departamento` varchar(25) NULL,
  
  `nCuenta` varchar(9) NULL,
  `carrera` varchar(50) NULL,
  
  PRIMARY KEY  (`id_usuario`),
  UNIQUE(`email`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

DROP TABLE IF EXISTS `cita`;
CREATE TABLE `cita` (
  `id_cita` int(11) NOT NULL auto_increment,
  `id_profesor` int(11) NOT NULL,
  `id_alumno` int(11) NULL,
  `lugar` varchar(50) NOT NULL,
  `fecha` date NOT NULL,
  `hora` varchar(50) NOT NULL,
  `solicitada` boolean NOT NULL,
  `asignada` boolean NOT NULL,
  `activa` boolean NOT NULL,
  `materia` varchar(50) NOT NULL,
  
  PRIMARY KEY  (`id_cita`),
  FOREIGN KEY  (`id_profesor`)REFERENCES usuario(`id_usuario`),
  FOREIGN KEY  (`id_alumno`)REFERENCES usuario(`id_usuario`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=2200 ;

LOCK TABLES `usuario` WRITE;
INSERT INTO `usuario` VALUES (1,'Fernando','Sánchez','Montoya','Facultad de Ciencias', false,'feroasmon@gmail.com','perrodelmal',null ,null ,'309160568' ,'CC');
INSERT INTO `usuario` VALUES (2,'Antonio','Ayala','Garras','Facultad de Ingenieria', true,'ayalaantony@gmail.com', 'chinojapones','AAGA78978' ,'Ingeniería', null ,null );
UNLOCK TABLES;

LOCK TABLES `cita` WRITE;
INSERT INTO `cita` VALUES (2200,2,1,'Facultad de Ciencias','2019-10-25','11:00',false,true,true,'Fisica');
INSERT INTO `cita` VALUES (2205,2,null,'Facultad de Ingenieria','2019-11-22','12:00',false,false,true,'Fisica');
INSERT INTO `cita` VALUES (2208,2,1,'IIMAS','2019-12-12','13:00',true,false,true,'Computacion');
INSERT INTO `cita` VALUES (2209,2,1,'IIMAS','2019-10-31','11:00',false,true,true,'Fisica');
INSERT INTO `cita` VALUES (2210,2,null,'Facultad de Ciencias','2019-11-02','12:00',false,false,true,'Computacion');
INSERT INTO `cita` VALUES (2222,2,1,'Facultad de Ingenieria','2019-12-12','13:00',true,false,true,'Matematicas');
UNLOCK TABLES;