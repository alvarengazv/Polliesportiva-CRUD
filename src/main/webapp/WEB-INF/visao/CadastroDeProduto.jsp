<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="modelo.Produto"%>
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
		<title> Cadastro de Produtos </title>
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
 			}
 			.btn-primary:hover{
 				background-color: #ffbb80!important;
 			}
 			tr:hover{
 				background-color: #ffd2ab!important;
 			}
 			th, td{
 				width: 50%;
 			}
 			.table td, .table th{
 				border-top: none;
 			}
		</style>
	</head>
	<body>
	
<nav class="fixed-top">
	<div class="barrainicial">
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
			<a class="usuario" style="background-color: white;" href=""><img style="width: 80%; height: 80%;" src="imagens/carrinho.png"></a>
		</div>
	</div>

	<div class="barra1"><ul class="menu1">
	<li><a href="">SOBRE NÓS</a></li>
	<li><a href="">ACADEMIA</a></li>
	<li><a href="">BASQUETE</a></li>
	<li><a href="">CICLISMO</a></li>
	<li><a href="">CORRIDA</a></li>
	<li><a href="">FUTEBOL</a></li>
	<li><a href="">NATAÇÃO</a></li>
	<li><a href="">TÊNIS</a></li>
	<li><a href="">VÔLEI</a></li>
	<li><a href="">FAQ</a></li>
	<li style="border-right: #FF7804;"><a href="">POLÍTICAS </a></li>
	</ul></div>
</nav>

<div class="container">
	<div style="margin: auto; width: 75%; text-align: center;">
		<h1 style="text-align: center;"> ${msg} </h1>
		<c:choose>
			<c:when test="${produto != null}">
						<table class="table table-hover" style="margin: auto; width: 40%;">
							<tr>
								<th style="text-align: right;">Imagem:</th>
								<c:if test="${produto.nomeArq != null}">
									<td style="text-align: left;"><img style="max-width: 100%; max-height: 100%;" alt="*Imagem*" title="${produto.nomeArq}" src="${produto.nomeArq}"></td>
								</c:if>
							</tr>
							<tr>
								<th style="text-align: right;">Código:</th>
								<td style="text-align: left;">${produto.cod}</td>
							</tr>
							<tr>
								<th style="text-align: right;">Nome:</th>
								<td style="text-align: left;">${produto.nome}</td>
							</tr>
							<tr>
								<th style="text-align: right;">Preço:</th>
								<td style="text-align: left;">${produto.preco}</td>
							</tr>
							<tr>
								<th style="text-align: right;">Marca:</th>
								<td style="text-align: left;">${produto.marca}</td>
							</tr>
							<tr>
								<th style="text-align: right;">Fornecedor:</th>
								<td style="text-align: left;">${produto.fornecedor}</td>
							</tr>
							<tr>
								<th style="text-align: right;">Categoria:</th>
								<td style="text-align: left;">${produto.categoria}</td>
							</tr>
							<tr>
								<th style="text-align: right;">SubCategoria:</th>
								<td style="text-align: left;">${produto.subcategoria}</td>
							</tr>
							<tr>
								<th style="text-align: right;">Descrição:</th>
								<td style="text-align: left;">${produto.descricao}</td>
							</tr>
					</table><br>
					<a href="controladorP?acao=gerenciarProdutos"><button id="botCad" style="float: right; background-color: #FF7804; border-color: #CC5F02; font-weight: bold;" class="btn btn-primary mb-2" >Gerenciamento de Produtos <i class="fa fa-long-arrow-right" aria-hidden="true"></i></button></a>
			</c:when>
			<c:otherwise>
				<a href="controladorP?acao=gerenciarProdutos"><button id="botCad" style="background-color: #FF7804; border-color: #CC5F02; font-weight: bold;" class="btn btn-primary mb-2" >Gerenciamento de Produtos <i class="fa fa-long-arrow-right" aria-hidden="true"></i></button></a>
			</c:otherwise>
		</c:choose>
	</div>
</div>
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
<a href="#" class="a" id="a"><img style="position: relative;width: 23px;height: 23px; top:5px;" src="imagens/instagram.png"> INSTAGRAM</a><br><br>
<a href="#" class="a" id="a"><img style="position:relative; width: 23px;height: 23px; top:5px;" src="imagens/facebook.png"> FACEBOOK</a><br><br>
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