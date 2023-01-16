<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="modelo.Cliente" %>

<!DOCTYPE html>
<html lang="pt-BR">
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/SiteCss.css">
		<title> Atualização de Informações </title>
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
 			.prodImg:hover{
 				transform: scale(2);
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
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js" integrity="sha512-pHVGpX7F/27yZ0ISY+VVjyULApbDlD0/X0rgGbTqCE7WFW5MezNTWG/dnhtbBuICzsd0WQPgpE4REBLv+UqChw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.js" integrity="sha512-0XDfGxFliYJPFrideYOoxdgNIvrwGTLnmK20xZbCAvPfLGQMzHUsaqZK8ZoH+luXGRxTrS46+Aq400nCnAT0/w==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
		<c:choose>
			<c:when test="${cliente != null}">
				<h3 style="text-align: center;"> Atualização de Informações. Cliente: ${cliente.cpf}</h3><br>
				<div style="margin: auto; width: 75%;">
					<form style="margin: auto; width: 100%;" action="controladorC?acao=atualizarCliente&codCli=${cliente.cod}" method="post" enctype="multipart/form-data">
						<div class="custom-file">
							<label style="color: #495057; font-weight: normal;" class="custom-file-label" for="customFileLang">Imagem do perfil...</label>
							<input aria-describedby="imgCliente" id="customFileLang" name="imagemPerfil" lang="pt-BR" style="background-color:  #FF7804;float: right; z-index: 10;" type="file" class="custom-file-input">
							<input type="hidden" name="naoAtualizado" value="${cliente.nomeArq}">
							<c:if test="${cliente.nomeArq != null}">
								<br><br><br>
								<h6 style="font-weight: bold">Imagem já Cadastrada: <img class="prodImg" title="${cliente.nomeArq}" style="position: relative; left: 19%; max-width: 20%; max-height: 20%; z-index: 100;" alt="*Imagem*" src="${cliente.nomeArq}"></h6>
								<br>
							</c:if>
						</div>
						<div class="form-group">
							<label for="nomeCliente"> Nome: </label>
							<input required="required" class="form-control" type="text" id="nomeCliente" name="nomeCliente" pattern="[a-zA-Z\s]*" value="${cliente.nome}">
						</div>
						<div class="form-group">
							<label for="sexoCliente"> Sexo: </label>
							<input type="hidden" value="${cliente.sexo}" name="sexoCliente">${cliente.sexo}
						</div>
						<div class="form-group">
							<label for="cpfCliente"> CPF: </label>
							<input required="required" class="form-control" type="hidden" id="cpfCliente" name="cpfCliente" pattern="[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}" value="${cliente.cpf}%>">${cliente.cpf}
						</div>
						<div class="form-group">
							<label for="nascimentoCliente"> Data de Nascimento: </label>
							<input required="required" class="form-control" type="hidden" id="nascimentoCliente" name="nascimentoCliente" value="${cliente.dataNasc}">${cliente.dataNasc}
						</div>
						<div class="form-group">
							<label for="telefoneCliente"> Telefone: </label>
							<input required="required" class="form-control" type="text" id="telefoneCliente" name="telefoneCliente" pattern="\([0-9]{2}\)[\s][0-9]{1}[\s][0-9]{4}-[0-9]{4}" value="${cliente.tel}">
						</div>
						<div class="form-group">
							<label for="emailCliente"> E-mail: </label>
							<input required="required" class="form-control" type="email" id="emailCliente" name="emailCliente" value="${cliente.email}">
						</div>
						<div class="form-group">
							<label for="senhaCliente"> Senha: </label>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroupPrepend3"><a href="#" style="color: black"><i class="fa fa-eye" aria-hidden="true"></i></a></span>
								</div>
								<input required="required" class="form-control" type="password" id="senhaCliente" name="senhaCliente" value="${cliente.senha}">				
							</div>
						</div>
						<div class="form-group">
							<div class="form-check">
							<c:set var="teste">Sim</c:set>
								<input <c:if test="${cliente.notificacao eq teste}">checked</c:if> class="form-check-input" type="checkbox" id="desejaNotificacao" name="desejaNotificacao" value="Sim">
								<label class="form-check-label" for="desejaNotificacao">
								  Desejo receber notificações de novas promoções da loja.
								</label>
							</div>
						</div>
						<button id="botCad" style="float: right; background-color: #FF7804; border-color: #CC5F02;" type="submit" class="btn btn-primary mb-2" >Alterar Informações</button>
					</form>
					<script type="text/javascript">
						$('#cpfCliente').mask('000.000.000-00');
						$('#telefoneCliente').mask('(00) 9 0000-0000');
						
						$(document).ready(function() {
						    $(".input-group a").on('click', function(event) {
						        event.preventDefault();
						        if($('.input-group input').attr("type") == "text"){
						            $('.input-group input').attr('type', 'password');
						        }else if($('.input-group input').attr("type") == "password"){
						            $('.input-group input').attr('type', 'text');
						        }
						    });
						});
					</script>
				</div>
			</c:when>
			<c:otherwise>
				<h3 style="text-align: center; color: red;">Este cliente não está cadastrado!</h3><br>
					<div style="width: 50%; margin: auto; display: flex; justify-content: center;">
						<a href="controladorC?acao=gerenciarClientes"><button id="botCad" style="background-color: #FF7804; border-color: #CC5F02; font-weight: bold;" class="btn btn-primary mb-2" >Voltar ao Gerenciamento de Produtos <i class="fa fa-long-arrow-right" aria-hidden="true"></i></button></a>
					</div>
			</c:otherwise>
		</c:choose>
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