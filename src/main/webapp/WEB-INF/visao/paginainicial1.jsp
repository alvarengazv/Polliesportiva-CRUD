<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="pt-BR">
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" type="text/css" href="SiteCss.css">

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Open+Sans">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body {
	background: #f5f5f5;
	font-family: "Open Sans", sans-serif;
}
h2 {
	color: #000;
	font-size: 26px;
	font-weight: 300;
	text-align: center;
	text-transform: uppercase;
	position: relative;
	margin: 30px 0 60px;
}
h2::after {
	content: "";
	width: 100px;
	position: absolute;
	margin: 0 auto;
	height: 4px;
	border-radius: 1px;
	background: #FF7804;
	left: 0;
	right: 0;
	bottom: -20px;
}
.carousel {
	margin: 50px auto;
	padding: 0 70px;
}
.carousel .item {
	color: #747d89;
	min-height: 325px;
    text-align: center;
	overflow: hidden;
}
.carousel .thumb-wrapper {
	padding: 25px 15px;
    height: 360px;
    width: 220px;
	background: #fff;
	border-radius: 6px;
	text-align: center;
	position: relative;
	box-shadow: 0 2px 3px rgba(0,0,0,0.2);
}

.carousel .thumb-wrapper:hover{
border: solid 0.5px #f19b4f;
}

.carousel .item .img-box {
	height: 180px;
	margin-bottom: 20px;
	width: 100%;
	position: relative;
}

.carousel .item img {	
	max-width: 100%;
	max-height: 100%;
	display: inline-block;
	position: absolute;
	bottom: 0;
	margin: 0 auto;
	left: 0;
	right: 0;
}
.carousel .item h4 {
	font-size: 16px;
}
.carousel .item h4, .carousel .item p, .carousel .item ul {
	margin-bottom: 5px;
}
.carousel .thumb-content .btn {
	color: #FF7804;
    font-size: 11px;
    text-transform: uppercase;
    font-weight: bold;
    background: none;
    border: 1px solid #FF7804;
    padding: 6px 14px;
    margin-top: 5px;
    line-height: 16px;
    border-radius: 20px;
}
.carousel .thumb-content .btn:hover, .carousel .thumb-content .btn:focus {
	color: #fff;
	background: #FF7804;
	box-shadow: none;
}
.carousel .thumb-content .btn i {
	font-size: 14px;
    font-weight: bold;
    margin-left: 5px;
}
.carousel .carousel-control {
	height: 44px;
	width: 32px;
	background: #FF7804;	
    margin: auto 0;
    border-radius: 4px;
	opacity: 0.8;
}
.carousel .carousel-control:hover {
	background: #FF7804;
	opacity: 1;
}
.carousel .carousel-control i {
    font-size: 36px;
    position: absolute;
    top: 50%;
    display: inline-block;
    margin: -19px 0 0 0;
    z-index: 5;
    left: 0;
    right: 0;
    color: #fff;
	text-shadow: none;
    font-weight: bold;
}
.carousel .item-price {
	font-size: 19px;
    color: #CC5F02;
	padding: 2px 0;
}
.carousel .item-price strike {
	opacity: 0.7;
	margin-right: 5px;
    font-size: 12px;
}
.carousel .carousel-control.left i {
	margin-left: -2px;
}
.carousel .carousel-control.right i {
	margin-right: -4px;
}
.carousel .carousel-indicators {
	bottom: -50px;
}
.carousel-indicators li, .carousel-indicators li.active {
	width: 10px;
	height: 10px;
	margin: 4px;
	border-radius: 50%;
	border: none;
}
.carousel-indicators li {	
	background: rgba(0, 0, 0, 0.2);
}
.carousel-indicators li.active {	
	background: rgba(0, 0, 0, 0.6);
}
.carousel .wish-icon {
	position: absolute;
	right: 10px;
	top: 10px;
	z-index: 99;
	cursor: pointer;
	font-size: 16px;
	color: #abb0b8;
}
.carousel .wish-icon .fa-heart {
	color: #ff6161;
}
.star-rating li {
	padding: 0;
}
.star-rating i {
	font-size: 14px;
	color: #ffc000;
}

p{
    text-align: center;
}
</style>
<script>
	$(document).ready(function(){
		$(".wish-icon i").click(function(){
			$(this).toggleClass("fa-heart fa-heart-o");
		});
	});	
</script>

		<title> Polliesportiva </title>
		<style type="text/css">
			input::-webkit-outer-spin-button,
			input::-webkit-inner-spin-button {
				-webkit-appearance: none;
  				margin: 0;
			}
			.custom-file-label::after, .input-group-text{
 				background-color:  #FF7804;
 				color: black;
 				font-weight: bold;
 			}
 			.form-control, .custom-file-label, .input-group-text{
 				border-color:  #FF7804;
 			}
 			label{
 				color: black;
 				font-weight: bold;
 			}
 			#botCad{
 				color: black;
 				font-weight: bold;
 				transition-duration: 0.2s;
 				min-width: 200px;
 			}
 			.btn-primary:hover{
 				background-color: #f19b4f!important;
 			}
 		
 			
 			th, td{
 				width: 50%;
 			}
 			.table td, .table th{
 				border-top: none;
 			}
 			.hidden{
 				display: none;
 			}
 			.botaoSenha:hover{
 				cursor: pointer;
 			}
             td{
                 width: 160px; font-size: 12px; padding: 5px 6px;
             }
             td img{
                right: 0%;
             }
		</style>
	</head>
	<body>
<!--BARRA INICIAL-->
<nav class="fixed-top">
	<div class="barrainicial"  >
		<div class="p1">
			<a class="logo" href="controlador?acao=paginaInicial"></a>
		</div>
		<div class="p2">
			<form style="width:50%; height: 37%;display: flex; flex-flow:row-reverse;" action="search"  method="get">
			    <input style="border: none; padding-left: 5px;" class="pesquisa" name="q" type="text" value="" placeholder="O que você procura?" />
			    <button style="border: none;" class="lupa" ><img style="width:75%;height: 75%;" src="imagens/lupa.png"/></button>
			</form>
			
			<a class="usuario" href="controlador?acao=perfilUsuario"><img style="width: 90%; height: 93%;" src="imagens/usuario.png"></a>
			<c:choose><c:when test="${empty online}"><div class="cor"><a href="controlador?acao=formLogin" class="aa" style="font-weight: bold">Entre ou Cadastre-se</a></div></c:when><c:otherwise><div class="cor"><a href="controlador?acao=logoutUsuario" class="aa" style="font-weight: bold">Logout</a></div></c:otherwise></c:choose>
			<a class="usuario" style="background-color: white;" href="controlador?acao=adicionarCarrinho"><img style="width: 80%; height: 80%;" src="imagens/carrinho.png"></a>
		</div>
	</div>

		<div class="barra1">
			<ul style="height: 100%" class="menu1">
				<li style="height: 100%"><a style="height: 100%" href="">SOBRE NÓS</a></li>
				<li style="height: 100%"><a style="height: 100%" href="">ACADEMIA</a></li>
				<li style="height: 100%"><a style="height: 100%" href="">BASQUETE</a></li>
				<li style="height: 100%"><a style="height: 100%" href="">CICLISMO</a></li>
				<li style="height: 100%"><a style="height: 100%" href="">CORRIDA</a></li>
				<li style="height: 100%"><a style="height: 100%" href="">FUTEBOL</a></li>
				<li style="height: 100%"><a style="height: 100%" href="">NATAÇÃO</a></li>
				<li style="height: 100%"><a style="height: 100%" href="">TÊNIS</a></li>
				<li style="height: 100%"><a style="height: 100%" href="">VÔLEI</a></li>
				<li style="height: 100%"><a style="height: 100%" href="">FAQ</a></li>
				<li style="border-right: #FF7804;"><a style="height: 100%" href="">POLÍTICAS </a></li>
			</ul>
		</div>
	</nav>
	<div style="padding: 0%; position: absolute; background-color: #c7620a; height: 50px; width: 100%;">
		<table style="margin: auto">
			<tr>
				<td style="padding: 5px 6px 0px 120px;"><img
					src="imagens/caminhao-de-transporte.png"
					style="width: 35px; height: 35px;"></td>
				<td><strong>ENTREGAS </strong> </br>PARA TODO O BRASIL</td>
				</a>
				<td style="padding-left: 120px;"><img
					src="imagens/desconto.png"
					style="width: 35px; height: 35px; right: 0%;"></td>
				<td><strong>OFERTAS</strong><br>IMPERDÍVEIS</td>
				<td style="padding-left: 120px;"><img
					src="imagens/cadeado-trancado.png"
					style="width: 35px; height: 35px;"></td>
				<td><strong>LOJA SEGURA</strong><br>COMPRA PROTEGIDA</td>
				<td style="padding-left: 120px;"><img
					src="imagens/pagamento-com-cartao-de-credito.png"
					style="width: 35px; height: 35px;"></td>
				<td><strong>INÚMERAS</strong><br>FORMAS DE PAGAMENTO</td>
			</tr>
		</table>
	</div>


	<!-- CARROSSEL ANUNCIOS-->
<div id="carouselExampleFade" class="carousel slide carousel-fade barra" data-ride="carousel" style="padding: 0%;">
    <div class="carousel-inner">
      <div class="carousel-item active">
        <a href="https://cycling.001shop.com.br/Default.aspx" target="_blank"><img class="d-block w-100" src="imagens/anuncio1.jpeg" alt="Primeiro Slide" style="height:490px"></a>
      </div>
      <div class="carousel-item">
        <a href="https://www.netshoes.com.br/running/tenis" target="_blank"><img class="d-block w-100" src="imagens/anuncio2.jpg" alt="Segundo Slide" style="height:490px"></a>
      </div>
      <div class="carousel-item">
        <a href="https://www.protenista.com.br/" target="_blank"><img class="d-block w-100" src="imagens/anuncio3.jpg" alt="Terceiro Slide" style="height:490px"></a>
      </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleFade" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Anterior</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleFade" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Próximo</span>
    </a>  <div style="padding: 0%;right: 0%; position:absolute; background-color: #CC5F02; height: 50px; width: 65%; border-bottom-left-radius: 100%;"></div>

  </div>
<!-- CARROSSEL 1 - DESTAQUES-->
    <div class="container" style="padding: 0%;">
        <div class="row">
            <div class="col-md-12">
                <h2><b>Destaques</b></h2>
                <div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="0" >
                <!-- Indicador Carrosel 
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                    <li data-target="#myCarousel" data-slide-to="2"></li>
                </ol>   
                <- PRODUTOS -->
                <div class="carousel-inner" >
                    <div class="item active" >
                        <div class="row">
                            <div class="col-sm-3">
                                <div class="thumb-wrapper zoom"> 
                                    <span class="wish-icon"><i class="fa fa-heart-o"></i></span>
                                    <div class="img-box">
                                        <img src="imagens/Produtos/tenis-nike.png" class="img-responsive" alt="">									
                                    </div>
                                    <div class="thumb-content">
                                        <h4>Tênis Nike React </h4>									
                                        <p class="item-price"><strike>$549.00</strike><br> <b>$449.99</b></p>
                                        <a href="controlador?acao=adicionarCarrinho&cod=17" class="btn btn-primary">Adicionar ao carrinho</a>
                                    </div>						
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="thumb-wrapper zoom">
                                    <span class="wish-icon"><i class="fa fa-heart-o"></i></span>
                                    <div class="img-box">
                                        <img src="imagens/Produtos/mochila_manila.jpg" class="img-responsive" alt="">
                                    </div>
                                    <div class="thumb-content">
                                        <h4>Mochila Esportiva Manila</h4>									
                                        <p class="item-price"><strike>$99.95</strike><br><b>$85.95</b></p>
                                        <a href="controlador?acao=adicionarCarrinho&cod=18" class="btn btn-primary">Adicionar ao carrinho</a>
                                    </div>						
                                </div>
                            </div>		
                            <div class="col-sm-3">
                                <div class="thumb-wrapper zoom">
                                    <span class="wish-icon"><i class="fa fa-heart-o"></i></span>
                                    <div class="img-box">
                                        <img src="imagens/Produtos/Nike-Revolution.jpg" class="img-responsive" alt="">
                                    </div>
                                    <div class="thumb-content">
                                        <h4>Tênis Nike Revolution 6</h4>									
                                        <p class="item-price"><strike>$349.99</strike><br><b>$279.99</b></p>
                                        <a href="controlador?acao=adicionarCarrinho&cod=19" class="btn btn-primary">Adicionar ao carrinho</a>
                                    </div>						
                                </div>
                            </div>								
                            <div class="col-sm-3">
                                <div class="thumb-wrapper zoom">
                                    <span class="wish-icon"><i class="fa fa-heart-o"></i></span>
                                    <div class="img-box">
                                        <img src="imagens/Produtos/Short-Corrida-Arsuxed.jpg" class="img-responsive" alt="">
                                    </div>
                                    <div class="thumb-content">
                                        <h4>Short de Corrida ARSUXEO 2 em 1</h4>									
                                        <p class="item-price"><strike>$449.90</strike> <b>$391.00</b></p>
                                        <a href="controlador?acao=adicionarCarrinho&cod=20" class="btn btn-primary">Adicionar ao carrinho</a>
                                    </div>						
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="row">
                            <div class="col-sm-3">
                                <div class="thumb-wrapper zoom">
                                    <span class="wish-icon"><i class="fa fa-heart-o"></i></span>
                                    <div class="img-box">
                                        <img src="imagens/Produtos/top-adidas.jpg" class="img-responsive" alt="">
                                    </div>
                                    <div class="thumb-content">
                                        <h4>Top Esportivo Adidas</h4>
                                        <p class="item-price"><strike>$129.90</strike> <span>$99.90</span></p>
                                        <a href="controlador?acao=adicionarCarrinho&cod=21" class="btn btn-primary">Adicionar ao carrinho</a>
                                    </div>						
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="thumb-wrapper zoom">
                                    <span class="wish-icon"><i class="fa fa-heart-o"></i></span>
                                    <div class="img-box">
                                        <img src="imagens/Produtos/Viseira-adidas.jpg" class="img-responsive" alt="">
                                    </div>
                                    <div class="thumb-content">
                                        <h4>Viseira Esportiva Adidas</h4>
                                        <p class="item-price"><strike>$199.00</strike> <span>$129.00</span></p>
                                        <a href="controlador?acao=adicionarCarrinho&cod=22" class="btn btn-primary">Adicionar ao carrinho</a>
                                    </div>						
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="thumb-wrapper zoom">
                                    <span class="wish-icon"><i class="fa fa-heart-o"></i></span>
                                    <div class="img-box">
                                        <img src="imagens/Produtos/tenis-adrun.jpg"img-responsive" alt="">
                                    </div>
                                    <div class="thumb-content">
                                        <h4>Tênis Feminino Adrun Type</h4>
                                        <p class="item-price"><strike>$109.00</strike> <span>$99.00</span></p>
                                        <a href="controlador?acao=adicionarCarrinho&cod=23" class="btn btn-primary">Adicionar ao carrinho</a>
                                    </div>						
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="thumb-wrapper zoom">
                                    <span class="wish-icon"><i class="fa fa-heart-o"></i></span>
                                    <div class="img-box">
                                        <img src="imagens/Produtos/Tenis-alc.jpg" class="img-responsive" alt="">
                                    </div>
                                    <div class="thumb-content">
                                        <h4>Tênis Esportivo ALC70</h4>
                                        <p class="item-price"><strike>$299.00</strike> <span>$269.00</span></p>
                                        <a href="controlador?acao=adicionarCarrinho&cod=24" class="btn btn-primary">Adicionar ao carrinho</a>
                                    </div>						
                                </div>
                            </div>						
                        </div>
                    </div>
                    <div class="item">
                        <div class="row">
                            <div class="col-sm-3">
                                <div class="thumb-wrapper zoom">
                                    <span class="wish-icon"><i class="fa fa-heart-o"></i></span>
                                    <div class="img-box">
                                        <img src="imagens/Produtos/legging-lupo.jpg" class="img-responsive" alt="">
                                    </div>
                                    <div class="thumb-content">
                                        <h4>Calça Legging Lupo Energy</h4>
                                        <p class="item-price"><strike>$159.00</strike> <span>$110.00</span></p>
                                        <a href="controlador?acao=adicionarCarrinho&cod=25" class="btn btn-primary">Adicionar ao carrinho</a>
                                    </div>						
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="thumb-wrapper zoom">
                                    <span class="wish-icon"><i class="fa fa-heart-o"></i></span>
                                    <div class="img-box">
                                        <img src="imagens/Produtos/short-nike.jpg" class="img-responsive" alt="">
                                    </div>
                                    <div class="thumb-content">
                                        <h4>Short Nike Flex</h4>
                                        <p class="item-price"><strike>$315.00</strike> <span>$250.00</span></p>
                                        <a href="controlador?acao=adicionarCarrinho&cod=26" class="btn btn-primary">Adicionar ao carrinho</a>
                                    </div>						
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="thumb-wrapper zoom">
                                    <span class="wish-icon"><i class="fa fa-heart-o"></i></span>
                                    <div class="img-box">
                                        <img src="imagens/Produtos/tenis-adidas.jpg" class="img-responsive" alt="">
                                    </div>
                                    <div class="thumb-content">
                                        <h4>Tênis Adidas Run Falcon</h4>
                                        <p class="item-price"><strike>$450.00</strike> <span>$418.00</span></p>
                                        <a href="controlador?acao=adicionarCarrinho&cod=27" class="btn btn-primary">Adicionar ao carrinho</a>
                                    </div>						
                                </div>
                            </div>	
                            <div class="col-sm-3">
                                <div class="thumb-wrapper zoom">
                                    <span class="wish-icon"><i class="fa fa-heart-o"></i></span>
                                    <div class="img-box">
                                        <img src="imagens/Produtos/camisa-strike.png" class="img-responsive" alt="">
                                    </div>
                                    <div class="thumb-content">
                                        <h4>Camisa Ciclismo Strike Refactor</h4>
                                        <p class="item-price"><strike>$350.00</strike> <span>$230.00</span></p>
                                        <a href="controlador?acao=adicionarCarrinho&cod=28" class="btn btn-primary">Adicionar ao carrinho</a>
                                    </div>						
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Carousel controls -->
                <a class="carousel-control left" href="#myCarousel" data-slide="prev" Style="background-color:#FF7804;">
                    <i class="fa fa-angle-left"></i>
                </a>
                <a class="carousel-control right" href="#myCarousel" data-slide="next" Style="background-color:#FF7804;">
                    <i class="fa fa-angle-right"></i>
                </a>
            </div>
            </div>
        </div>
    
    </div>
    
    <div style="padding: 0%; background-color: #CC5F02; height: 50px; width: 55%; border-top-right-radius: 100%;"></div>

<!--CARROSSEL 2 -->
    <div class="container" style="padding: 0%;">
   
        <div class="row">
            <div class="col-md-12">
                <h2><b>LANÇAMENTOS</b></h2>
                <div id="mCarousel" class="carousel slide" data-ride="carousel" data-interval="0" >
                <!-- Indicador Carrosel ==
                <ol class="carousel-indicators">
                    <li data-target="#mCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#mCarousel" data-slide-to="1"></li>
                    <li data-target="#mCarousel" data-slide-to="2"></li>
                </ol>   
                <- PRODUTOS -->
                <div class="carousel-inner" >
                    <div class="item active" >
                        <div class="row">
                            <div class="col-sm-3">
                                <div class="thumb-wrapper zoom"> 
                                    <span class="wish-icon"><i class="fa fa-heart-o"></i></span>
                                    <div class="img-box">
                                        <img src="imagens/Produtos/oculos-natacao.jpg" class="img-responsive" alt="">									
                                    </div>
                                    <div class="thumb-content">
                                        <h4>Óculos de Natação Xbase</h4>									
                                        <p class="item-price"><b>$39.90</b></p>
                                        <a href="controlador?acao=adicionarCarrinho&cod=29" class="btn btn-primary">Adicionar ao carrinho</a>
                                    </div>						
                                </div>
                            </div>
								<div class="col-sm-3">
									<div class="thumb-wrapper zoom">
										<span class="wish-icon"><i class="fa fa-heart-o"></i></span>
										<div class="img-box">
											<img src="imagens/Produtos/joelheira-soft.jpeg"
												class="img-responsive" alt="">
										</div>
										<div class="thumb-content">
											<h4>Joelheira Soft 500</h4>
											<p class="item-price">
												<b>$59.90</b>
											</p>
											<a href="controlador?acao=adicionarCarrinho&cod=30" class="btn btn-primary">Adicionar ao carrinho</a>
										</div>
									</div>
								</div>
								<div class="col-sm-3">
                                <div class="thumb-wrapper zoom">
                                    <span class="wish-icon"><i class="fa fa-heart-o"></i></span>
                                    <div class="img-box">
                                        <img src="imagens/Produtos/Tenis-galaxy.jpg" class="img-responsive" alt="">
                                    </div>
                                    <div class="thumb-content">
                                        <h4>Tênis Adidas Galaxy 5</h4>									
                                        <p class="item-price"><b>$279.99</b></p>
                                        <a href="controlador?acao=adicionarCarrinho&cod=31" class="btn btn-primary">Adicionar ao carrinho</a>
                                    </div>						
                                </div>
                            </div>								
                            <div class="col-sm-3">
                                <div class="thumb-wrapper zoom">
                                    <span class="wish-icon"><i class="fa fa-heart-o"></i></span>
                                    <div class="img-box">
                                        <img src="imagens/Produtos/oculos-ciclismo.jpg" class="img-responsive" alt="">
                                    </div>
                                    <div class="thumb-content">
                                        <h4>Óculos Ciclismo HB SHIELD</h4>									
                                        <p class="item-price"><b>$250.00</b></p>
                                        <a href="controlador?acao=adicionarCarrinho&cod=32" class="btn btn-primary">Adicionar ao carrinho</a>
                                    </div>						
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="row">
                            <div class="col-sm-3">
                                <div class="thumb-wrapper zoom">
                                    <span class="wish-icon"><i class="fa fa-heart-o"></i></span>
                                    <div class="img-box">
                                        <img src="imagens/Produtos/tenis-olympikus.jpg" class="img-responsive" alt="">
                                    </div>
                                    <div class="thumb-content">
                                        <h4>Tênis Olympikus </h4>
                                        <p class="item-price"><b>$159.00</b></p>
                                        <a href="controlador?acao=adicionarCarrinho&cod=33" class="btn btn-primary">Adicionar ao carrinho</a>
                                    </div>						
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="thumb-wrapper zoom">
                                    <span class="wish-icon"><i class="fa fa-heart-o"></i></span>
                                    <div class="img-box">
                                        <img src="imagens/Produtos/raquete-tenis.png" class="img-responsive" alt="">
                                    </div>
                                    <div class="thumb-content">
                                        <h4>Raquete Wilson Clas</h4>
                                        <p class="item-price"><b>$869.00</b></p>
                                        <a href="controlador?acao=adicionarCarrinho&cod=34" class="btn btn-primary">Adicionar ao carrinho</a>
                                    </div>						
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="thumb-wrapper zoom">
                                    <span class="wish-icon"><i class="fa fa-heart-o"></i></span>
                                    <div class="img-box">
                                        <img src="imagens/Produtos/bola-basquete.jpg" class="img-responsive" alt="">
                                    </div>
                                    <div class="thumb-content">
                                        <h4>Bola de Basquete Baller Adidas</h4>
                                        <p class="item-price"><b>$99.00</b></p>
                                        <a href="controlador?acao=adicionarCarrinho&cod=35" class="btn btn-primary">Adicionar ao carrinho</a>
                                    </div>						
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="thumb-wrapper zoom">
                                    <span class="wish-icon"><i class="fa fa-heart-o"></i></span>
                                    <div class="img-box">
                                        <img src="imagens/Produtos/luva-academia.jpg" class="img-responsive" alt="">
                                    </div>
                                    <div class="thumb-content">
                                        <h4>Luva Gel Flux</h4>
                                        <p class="item-price"><b>$60.00</b></p>
                                        <a href="controlador?acao=adicionarCarrinho&cod=36" class="btn btn-primary">Adicionar ao carrinho</a>
                                    </div>						
                                </div>
                            </div>						
                        </div>
                    </div>
                    <div class="item">
                        <div class="row">
                            <div class="col-sm-3">
                                <div class="thumb-wrapper zoom">
                                    <span class="wish-icon"><i class="fa fa-heart-o"></i></span>
                                    <div class="img-box">
                                        <img src="imagens/Produtos/chuteira-nike.jpg" class="img-responsive" alt="">
                                    </div>
                                    <div class="thumb-content">
                                        <h4>Chuteira Nike Phantom</h4>
                                        <p class="item-price"><b>$139.00</b></p>
                                        <a href="controlador?acao=adicionarCarrinho&cod=37" class="btn btn-primary">Adicionar ao carrinho</a>
                                    </div>						
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="thumb-wrapper zoom">
                                    <span class="wish-icon"><i class="fa fa-heart-o"></i></span>
                                    <div class="img-box">
                                        <img src="imagens/Produtos/manguito-volei.jpg" class="img-responsive" alt="">
                                    </div>
                                    <div class="thumb-content">
                                        <h4>Manguito Protetor Buscapé</h4>
                                        <p class="item-price"><b>$25.00</b></p>
                                        <a href="controlador?acao=adicionarCarrinho&cod=38" class="btn btn-primary">Adicionar ao carrinho</a>
                                    </div>						
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="thumb-wrapper zoom">
                                    <span class="wish-icon"><i class="fa fa-heart-o"></i></span>
                                    <div class="img-box">
                                        <img src="imagens/Produtos/short-suplex.jpg" class="img-responsive" alt="">
                                    </div>
                                    <div class="thumb-content">
                                        <h4>Short Fitness Suplex</h4>
                                        <p class="item-price"><b>$109.00</b></p>
                                        <a href="controlador?acao=adicionarCarrinho&cod=39" class="btn btn-primary">Adicionar ao carrinho</a>
                                    </div>						
                                </div>
                            </div>	
                            <div class="col-sm-3">
                                <div class="thumb-wrapper zoom">
                                    <span class="wish-icon"><i class="fa fa-heart-o"></i></span>
                                    <div class="img-box">
                                        <img src="imagens/Produtos/capacete-ciclismo.jpg" class="img-responsive" alt="">
                                    </div>
                                    <div class="thumb-content">
                                        <h4>Capacete Align Speciallized</h4>
                                        <p class="item-price"><b>$449.00</b></p>
                                        <a href="controlador?acao=adicionarCarrinho&cod=40" class="btn btn-primary">Adicionar ao carrinho</a>
                                    </div>						
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Carousel controls -->
                <a class="carousel-control left" href="#mCarousel" data-slide="prev" Style="background-color:#FF7804;">
                    <i class="fa fa-angle-left"></i>
                </a>
                <a class="carousel-control right" href="#mCarousel" data-slide="next" Style="background-color:#FF7804;">
                    <i class="fa fa-angle-right"></i>
                </a>
            </div>
            </div>
        </div>        
</div>
<div style="display: flex; flex-direction: row; justify-content: space-around;">
	<div  class="zoom" style="position: relative;"><a href="#"><img src="imagens/jaqueta-corta-vento.png" style="width: 100%;"></a></div>
	<div class="zoom" style="position: relative;"><a href="#"><img src="imagens/top-dos-tops.png" style="width: 100%"></a></div>
	<div class="zoom" style="position: relative;"><a href="#"><img src="imagens/patinetes.png" style="width: 100%"></a></div>
</div>
<br><br><br>
<!-- BOTÕES DE ACESSO-->
<!--
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js" integrity="sha512-pHVGpX7F/27yZ0ISY+VVjyULApbDlD0/X0rgGbTqCE7WFW5MezNTWG/dnhtbBuICzsd0WQPgpE4REBLv+UqChw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.js" integrity="sha512-0XDfGxFliYJPFrideYOoxdgNIvrwGTLnmK20xZbCAvPfLGQMzHUsaqZK8ZoH+luXGRxTrS46+Aq400nCnAT0/w==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>	
		<div style="margin: auto; width: 75%; text-align: center;">
		<br><br><br>
			<a href="controladorP?acao=formCadastrarProduto"><button id="botCad" style="background-color: #FF7804; border-color: #CC5F02; font-weight: bold; margin: auto 0" class="btn btn-primary mb-2" > Cadastrar Produtos <i class="fa fa-long-arrow-right" aria-hidden="true"></i></button></a>
			<a href="controladorC?acao=formCadastrarCliente"><button id="botCad" style="background-color: #FF7804; border-color: #CC5F02; font-weight: bold; margin: auto 0" class="btn btn-primary mb-2" > Cadastrar Usuários <i class="fa fa-long-arrow-right" aria-hidden="true"></i></button></a>
		<br>	
			<a href="controlador?acao=formCadastrarEndereco"><button id="botCad" style="background-color: #FF7804; border-color: #CC5F02; font-weight: bold; margin: auto 0" class="btn btn-primary mb-2" > Cadastrar Endereço <i class="fa fa-long-arrow-right" aria-hidden="true"></i></button></a>
			<a href="controlador?acao=formCadastrarCartao"><button id="botCad" style="background-color: #FF7804; border-color: #CC5F02; font-weight: bold; margin: auto 0" class="btn btn-primary mb-2" > Cadastrar Cartão <i class="fa fa-long-arrow-right" aria-hidden="true"></i></button></a>
		<br><br><br><br>
		</div> -->

<!-- RODAPÉ -->
	<div class="R">
		<div class="rodape" >
	<div class="institucional"><br>
		<h4 style="color: #FF7804;">INSTITUCIONAL</h4>
<a href="" class="a">Sobre Nós</a><br><br>
<a href="" class="a">Nossa Empresa</a><br><br>
<a href="" class="a">FAQ</a><br><br>
<a href="" class="a">Fale Conosco</a><br><br>
<div class="logo1"><img src="imagens/logo2.png" style="width: 164px;
height: 126.34px"></div>
	</div>
	<div class="suporte"><br>
		<h4 style="color: #FF7804;">SUPORTE</h4>
<a  id="aa"><img style="position: relative;width: 23px;height: 23px; top: 5px;"src="imagens/email.png"><b> E-MAIL</b></a><br><a class="a" href="">sac@poliesportiva.com.br</a><br><br>
<a  id="aa"><img src="imagens/telefone.png" style="position: relative;width: 23px; height: 23px;top: 5px;"><b> TELEFONE</b><br><br>(37) 3221-1234 / 3221-5432<br>
<b style="font-size: 13px;">WhatsApp: </b>(37) 98801-2345</a><br><br>
<div id="aa" style="text-align: left;"><img src="imagens/relogio.png" style="position:relative;width: 23px;	height: 23px;top: 5px;"><b> HORÁRIOS DE ATENDIMENTO</b><br><br>
<a style="font-size:13px; color: white;">SEG - SEX das 9:00 ÀS 18:00<br>SAB DAS 9:00 àS 13:30<br>Exceto feriados</a></div><br><br>

	</div>
	<div class="midia"><br>
		<h4 style="color: #FF7804;">MÍDIAS SOCIAIS</h4>
<a href="" class="a" id="a"><img style="position: relative;width: 23px;height: 23px; top:5px;" src="imagens/instagram.png"> INSTAGRAM</a><br><br>
<a href="" class="a" id="a"><img style="position:relative; width: 23px;height: 23px; top:5px;" src="imagens/facebook.png"> FACEBOOK</a><br><br>
	</div>
	<div class="politica"><br>
		<h4 style="color: #FF7804;">POLÍTICAS DA LOJA</h4>
<a href="" class="a">Políticas de Troca e Devolução</a><br><br>
<a href="" class="a">Políticas de Frete</a><br><br>
<a href="" class="a">Políticas de Garantia</a><br><br>
<a href="" class="a">Fale Conosco</a>
		<br>
		<h4 style="color: #FF7804;">FORMAS DE PAGAMENTO</h4>
		<div class="pagamento"><a href=""><img style="width: 295px;height: 97px;" src="imagens/cartao.png"></a></div>
	</div>
</div>

<div class="rodape1"><div style="padding: 12px 0 12px; color: white;text-align: center; font-size: 13px;">SANBEL COMERCIO VAREJISTA DE ARTIGOS ESPORTIVOS LTDA - CNPJ: 37.012.345/6789-37<br> © Todos os direitos reservados. 2021<br><br>Empresa Fictícia com produtos, imagens e comprovantes meramente ilustrativos.</div></div>
		</div>
	</body>
</html>