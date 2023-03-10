<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  

<!DOCTYPE html>
<html lang="pt-BR">
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/SiteCss.css">
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
 			
 			.a1:hover{
 				background-color: white;
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
 			.hidden{
 				display: none;
 			}
 			/*.botaoSenha:hover{
 				cursor: pointer;
 			}*/
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
			    <input style="border: none; padding-left: 5px;" class="pesquisa" name="q" type="text" value="" placeholder="O que voc? procura?" />
			    <button style="border: none;" class="lupa" ><img style="width:75%;height: 75%;" src="imagens/lupa.png"/></button>
			</form>
			
			<a class="usuario" href="controlador?acao=perfilUsuario"><img style="width: 90%; height: 93%;" src="imagens/usuario.png"></a>
			<c:choose><c:when test="${empty online}"><div class="cor"><a href="controlador?acao=formLogin" class="aa" style="font-weight: bold">Entre ou Cadastre-se</a></div></c:when><c:otherwise><div class="cor"><a href="controlador?acao=logoutUsuario" class="aa" style="font-weight: bold">Logout</a></div></c:otherwise></c:choose>
			<a class="usuario" style="background-color: white;" href="controlador?acao=adicionarCarrinho"><img style="width: 80%; height: 80%;" src="imagens/carrinho.png"></a>
		</div>
	</div>

	<div class="barra1"><ul class="menu1">
	<li><a href="">SOBRE N?S</a></li>
	<li><a href="">ACADEMIA</a></li>
	<li><a href="">BASQUETE</a></li>
	<li><a href="">CICLISMO</a></li>
	<li><a href="">CORRIDA</a></li>
	<li><a href="">FUTEBOL</a></li>
	<li><a href="">NATA??O</a></li>
	<li><a href="">T?NIS</a></li>
	<li><a href="">V?LEI</a></li>
	<li><a href="">FAQ</a></li>
	<li style="border-right: #FF7804;"><a href="">POL?TICAS </a></li>
	</ul></div>
</nav>

<div class="container">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js" integrity="sha512-pHVGpX7F/27yZ0ISY+VVjyULApbDlD0/X0rgGbTqCE7WFW5MezNTWG/dnhtbBuICzsd0WQPgpE4REBLv+UqChw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.js" integrity="sha512-0XDfGxFliYJPFrideYOoxdgNIvrwGTLnmK20xZbCAvPfLGQMzHUsaqZK8ZoH+luXGRxTrS46+Aq400nCnAT0/w==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>	
		<div style="margin: auto; width: 90%; text-align: center; display: flex; flex-direction: column;">
			<br><br><br><br>
			<h2 style="text-align: center;">Bem vindo de volta, ${online.nome}!</h2>
			<div style="display: flex; flex-direction: row;">
				<div style="width: 50%;">
					<ul class="list-group" style="margin: 0; background-color: white; max-width: 100%; text-align: left; border-color: #CC5F02">
					<li class="list-group-item" style="margin: 0; width: auto; border-color: #CC5F02">
						<img alt="*Imagem*" title="${online.nomeArq}" src="${online.nomeArq}" class="img-thumbnail" style="max-width: 200px; max-height: 200px; display: block; border-color: #CC5F02; margin: auto" >
					</li>
						<li class="list-group-item"
							style="margin: 0; width: auto; border-color: #CC5F02"><b>NOME:</b><br>
							${online.nome}</li>
						<li class="list-group-item"
							style="margin: 0; width: auto; border-color: #CC5F02"><b>SEXO:</b><br>
							${online.sexo}</li>
						<li class="list-group-item"
							style="margin: 0; width: auto; border-color: #CC5F02"><b>CPF:</b><br>
							${online.cpf}</li>
						<li class="list-group-item"
							style="margin: 0; width: auto; border-color: #CC5F02"><b>DATA
								DE NASCIMENTO:</b><br> ${online.dataNasc}</li>
						<li class="list-group-item"
							style="margin: 0; width: auto; border-color: #CC5F02"><b>TELEFONE:</b><br>
							${online.tel}</li>
						<li class="list-group-item"
							style="margin: 0; width: auto; border-color: #CC5F02"><b>EMAIL:</b><br>
							${online.email}</li>
						<li class="list-group-item"
							style="margin: 0; width: auto; border-color: #CC5F02"><b>RECECBE
								NOTIFICA??ES:</b><br> ${online.notificacao}</li>
					</ul>
					<br> <a
						href="controladorC?acao=formAtualizarCliente&cod=${online.cod}"><button
							id="botCad"
							style="background-color: #FFFFB3; border-color: #CC5F02; color: black; font-weight: bold; height: 5%"
							class="btn btn-primary mb-2">
							Atualizar Informa??es <i class="fa fa-undo" aria-hidden="true"></i>
						</button></a>
				</div>
				<div style="width: 50%;">
					<ul class="list-group" style="margin: 0; background-color: white; max-width: 100%; text-align: center; border-color: #CC5F02">
						<li class="list-group-item" style="margin: 0; width: auto; border-color: #CC5F02">
							<b>ENDERE?OS CADASTRADOS:</b> ${qtdEnd}
							<a href="controladorE?acao=gerenciarEnderecos&codCli=${online.cod}" style="padding: 0" class="a1"><button id="botCad" style="min-width: 100%; min-height: 100%;margin: 0!important;background-color: #FFFFB3; border-color: #CC5F02; color: black; font-weight: bold; height: 100%" class="btn btn-primary mb-2">
								Gerenciar Endere?os
							</button></a>
						</li>
						<li class="list-group-item" style="margin: 0; width: auto; border-color: #CC5F02">
							<b>COMPRAS FEITAS:</b> ${qtdPedidos}
							<a href="controladorCompra?acao=gerenciarCompras" style="padding: 0" class="a1"><button id="botCad" style="min-width: 100%; min-height: 100%;margin: 0!important;background-color: #FFFFB3; border-color: #CC5F02; color: black; font-weight: bold; height: 100%" class="btn btn-primary mb-2">
								Gerenciar Compras
							</button></a>
						</li>
					</ul>
				</div>
			</div>
		</div>
</div>
	<div class="R">
		<div class="rodape" >
	<div class="institucional"><br>
		<h4 style="color: #FF7804;">INSTITUCIONAL</h4>
<a href="" class="a">Sobre N?s</a><br><br>
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
<div id="aa" style="text-align: left;"><img src="imagens/relogio.png" style="position:relative;width: 23px;	height: 23px;top: 5px;"><b> HOR?RIOS DE ATENDIMENTO</b><br><br>
<a style="font-size:13px; color: white;">SEG - SEX das 9:00 ?S 18:00<br>SAB DAS 9:00 ?S 13:30<br>Exceto feriados</a></div><br><br>

	</div>
	<div class="midia"><br>
		<h4 style="color: #FF7804;">M?DIAS SOCIAIS</h4>
<a href="" class="a" id="a"><img style="position: relative;width: 23px;height: 23px; top:5px;" src="imagens/instagram.png"> INSTAGRAM</a><br><br>
<a href="" class="a" id="a"><img style="position:relative; width: 23px;height: 23px; top:5px;" src="imagens/facebook.png"> FACEBOOK</a><br><br>
	</div>
	<div class="politica"><br>
		<h4 style="color: #FF7804;">POL?TICAS DA LOJA</h4>
<a href="" class="a">Pol?ticas de Troca e Devolu??o</a><br><br>
<a href="" class="a">Pol?ticas de Frete</a><br><br>
<a href="" class="a">Pol?ticas de Garantia</a><br><br>
<a href="" class="a">Fale Conosco</a>
		<br>
		<h4 style="color: #FF7804;">FORMAS DE PAGAMENTO</h4>
		<div class="pagamento"><a href=""><img style="width: 295px;height: 97px;" src="imagens/cartao.png"></a></div>
	</div>
</div>

<div class="rodape1"><div style="padding: 12px 0 12px; color: white;text-align: center; font-size: 13px;">SANBEL COMERCIO VAREJISTA DE ARTIGOS ESPORTIVOS LTDA - CNPJ: 37.012.345/6789-37<br> ? Todos os direitos reservados. 2021<br><br>Empresa Fict?cia com produtos, imagens e comprovantes meramente ilustrativos.</div></div>
		</div>
	</body>
</html>