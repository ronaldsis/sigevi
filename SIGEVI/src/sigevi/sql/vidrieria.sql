CREATE TABLE modulo (
  codMod INTEGER UNSIGNED NOT NULL,
  nomMod VARCHAR(45) NULL,
  PRIMARY KEY(codMod)
);

CREATE TABLE medida (
  codMed INTEGER UNSIGNED NOT NULL,
  nomMed VARCHAR(20) NULL,
  ancMed INTEGER NULL,
  larMed INTEGER NULL,
  simMed VARCHAR(10) NULL,
  PRIMARY KEY(codMed)
);

CREATE TABLE proveedor (
  codPrv INTEGER UNSIGNED NOT NULL,
  tipPrv VARCHAR(10) NULL,
  nomPrv VARCHAR(200) NULL,
  docPrv VARCHAR(11) NULL,
  dirPrv VARCHAR(200) NULL,
  telPrv VARCHAR(10) NULL,
  celPrv VARCHAR(10) NULL,
  emaPrv VARCHAR(100) NULL,
  PRIMARY KEY(codPrv)
);

CREATE TABLE perfil (
  codPer INTEGER UNSIGNED NOT NULL,
  nomPer VARCHAR(20) NULL,
  PRIMARY KEY(codPer)
);

CREATE TABLE despacho (
  codDes INTEGER UNSIGNED NOT NULL,
  nomDes VARCHAR(45) NULL,
  PRIMARY KEY(codDes)
);

CREATE TABLE cliente (
  codCli INTEGER UNSIGNED NOT NULL,
  tipCli VARCHAR(10) NULL,
  nomCli VARCHAR(200) NULL,
  docCli VARCHAR(11) NULL,
  dirCli VARCHAR(200) NULL,
  telCli VARCHAR(10) NULL,
  celCli VARCHAR(10) NULL,
  emaCli VARCHAR(100) NULL,
  PRIMARY KEY(codCli)
);

CREATE TABLE categoria (
  codCat INTEGER NOT NULL,
  nomCat VARCHAR(100) NULL,
  desCat VARCHAR(1000) NULL,
  PRIMARY KEY(codCat)
);

CREATE TABLE usuario (
  codUsu INTEGER UNSIGNED NOT NULL,
  logUsu VARCHAR(10) NULL,
  nomUsu VARCHAR(45) NULL,
  apeUsu VARCHAR(100) NULL,
  pasUsu VARCHAR(10) NULL,
  perfil_codPer INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(codUsu),
  INDEX tbUsuario_FKIndex1(perfil_codPer),
  FOREIGN KEY(perfil_codPer)
    REFERENCES perfil(codPer)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE producto (
  codPro INTEGER UNSIGNED NOT NULL,
  nomPro VARCHAR(100) NULL,
  desPro VARCHAR(200) NULL,
  stoPro DOUBLE NULL,
  categoria_codCat INTEGER NOT NULL,
  PRIMARY KEY(codPro),
  INDEX producto_FKIndex2(categoria_codCat),
  FOREIGN KEY(categoria_codCat)
    REFERENCES categoria(codCat)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE venta (
  nroVen INTEGER UNSIGNED NOT NULL,
  nroCom VARCHAR(10) NULL,
  tipCom VARCHAR(10) NULL,
  fecVen DATETIME NULL,
  usuario_codUsu INTEGER UNSIGNED NOT NULL,
  cliente_codCli INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(nroVen),
  INDEX venta_FKIndex1(usuario_codUsu),
  INDEX venta_FKIndex2(cliente_codCli),
  FOREIGN KEY(usuario_codUsu)
    REFERENCES usuario(codUsu)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(cliente_codCli)
    REFERENCES cliente(codCli)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE producto_medida (
  codProMed INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  producto_codPro INTEGER UNSIGNED NOT NULL,
  medida_codMed INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(codProMed),
  INDEX producto_medida_FKIndex1(producto_codPro),
  INDEX producto_medida_FKIndex2(medida_codMed),
  FOREIGN KEY(producto_codPro)
    REFERENCES producto(codPro)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(medida_codMed)
    REFERENCES medida(codMed)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE compra (
  nroCop INTEGER UNSIGNED NOT NULL,
  nroCom VARCHAR(10) NULL,
  tipCom VARCHAR(10) NULL,
  fecCom DATETIME NULL,
  usuario_codUsu INTEGER UNSIGNED NOT NULL,
  proveedor_codPrv INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(nroCop),
  INDEX compra_FKIndex1(proveedor_codPrv),
  INDEX compra_FKIndex2(usuario_codUsu),
  FOREIGN KEY(proveedor_codPrv)
    REFERENCES proveedor(codPrv)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(usuario_codUsu)
    REFERENCES usuario(codUsu)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE perfil_modulo (
  codPerMod INTEGER UNSIGNED NOT NULL,
  visible BOOL NULL,
  modulo_codMod INTEGER UNSIGNED NOT NULL,
  perfil_codPer INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(codPerMod),
  INDEX perfil_modulo_FKIndex1(perfil_codPer),
  INDEX perfil_modulo_FKIndex2(modulo_codMod),
  FOREIGN KEY(perfil_codPer)
    REFERENCES perfil(codPer)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(modulo_codMod)
    REFERENCES modulo(codMod)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE producto_despacho (
  codProDes INTEGER UNSIGNED NOT NULL,
  producto_codPro INTEGER UNSIGNED NOT NULL,
  despacho_codDes INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(codProDes),
  INDEX producto_tipoprecio_FKIndex1(producto_codPro),
  INDEX producto_despacho_FKIndex2(despacho_codDes),
  FOREIGN KEY(producto_codPro)
    REFERENCES producto(codPro)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(despacho_codDes)
    REFERENCES despacho(codDes)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE producto_precio (
  codProPre INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  producto_codPro INTEGER UNSIGNED NOT NULL,
  producto_medida_codProMed INTEGER UNSIGNED NOT NULL,
  producto_despacho_codProDes INTEGER UNSIGNED NOT NULL,
  precio DOUBLE NULL,
  PRIMARY KEY(codProPre),
  INDEX producto_precio_FKIndex1(producto_despacho_codProDes),
  INDEX producto_precio_FKIndex3(producto_codPro),
  INDEX producto_precio_FKIndex3(producto_medida_codProMed),
  FOREIGN KEY(producto_despacho_codProDes)
    REFERENCES producto_despacho(codProDes)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(producto_codPro)
    REFERENCES producto(codPro)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(producto_medida_codProMed)
    REFERENCES producto_medida(codProMed)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE detalle_venta (
  nroDet INTEGER UNSIGNED NOT NULL,
  canDet DOUBLE NULL,
  preDet DOUBLE NULL,
  venta_nroVen INTEGER UNSIGNED NOT NULL,
  producto_codPro INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(nroDet),
  INDEX detalleventa_FKIndex1(producto_codPro),
  INDEX detalleventa_FKIndex2(venta_nroVen),
  FOREIGN KEY(producto_codPro)
    REFERENCES producto(codPro)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(venta_nroVen)
    REFERENCES venta(nroVen)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE detalle_compra (
  nroDet INTEGER UNSIGNED NOT NULL,
  canDet DOUBLE NULL,
  preDet DOUBLE NULL,
  compra_nroCop INTEGER UNSIGNED NOT NULL,
  producto_codPro INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(nroDet),
  INDEX detallecompra_FKIndex1(compra_nroCop),
  INDEX detallecompra_FKIndex2(producto_codPro),
  FOREIGN KEY(compra_nroCop)
    REFERENCES compra(nroCop)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(producto_codPro)
    REFERENCES producto(codPro)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);


