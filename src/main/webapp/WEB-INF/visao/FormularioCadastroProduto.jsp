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
			    <input style="border: none; padding-left: 5px;" class="pesquisa" name="q" type="text" value="" placeholder="O que voc� procura?" />
			    <button style="border: none;" class="lupa" ><img style="width:75%;height: 75%;" src="imagens/lupa.png"/></button>
			</form>
			
			<a class="usuario" href="controlador?acao=perfilUsuario"><img style="width: 90%; height: 93%;" src="imagens/usuario.png"></a>
			<c:choose>
				<c:when test="${empty online}">
					<div class="cor"><a href="controlador?acao=formLogin" class="aa" style="font-weight: bold">Entre ou Cadastre-se</a></div>
				</c:when>
				<c:otherwise>
					<div class="cor"><a href="controlador?acao=logoutUsuario" class="aa" style="font-weight: bold">Logout</a></div>
				</c:otherwise>
			</c:choose>
			<a class="usuario" style="background-color: white;" href=""><img style="width: 80%; height: 80%;" src="imagens/carrinho.png"></a>
		</div>
	</div>
	
	<div class="barra1"><ul class="menu1">
	<li><a href="">SOBRE N�S</a></li>
	<li><a href="">ACADEMIA</a></li>
	<li><a href="">BASQUETE</a></li>
	<li><a href="">CICLISMO</a></li>
	<li><a href="">CORRIDA</a></li>
	<li><a href="">FUTEBOL</a></li>
	<li><a href="">NATA��O</a></li>
	<li><a href="">T�NIS</a></li>
	<li><a href="">V�LEI</a></li>
	<li><a href="">FAQ</a></li>
	<li style="border-right: #FF7804;"><a href="">POL�TICAS </a></li>
	</ul></div>
</nav>
	
	<div class="container">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js" integrity="sha512-pHVGpX7F/27yZ0ISY+VVjyULApbDlD0/X0rgGbTqCE7WFW5MezNTWG/dnhtbBuICzsd0WQPgpE4REBLv+UqChw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.js" integrity="sha512-0XDfGxFliYJPFrideYOoxdgNIvrwGTLnmK20xZbCAvPfLGQMzHUsaqZK8ZoH+luXGRxTrS46+Aq400nCnAT0/w==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
		<h3 style="text-align: center;"> Preencha os campos abaixo para cadastrar um produto na PolliEsportiva. </h3><br>
		<div style="margin: auto; width: 75%;">
			<form style="margin: auto; width: 100%;" action="controladorP?acao=cadastrarProduto" method="post" enctype="multipart/form-data">
				<div class="custom-file">
					<label style="color: #495057; font-weight: normal;" class="custom-file-label" for="customFileLang">Imagem do Produto...</label>
					<input aria-describedby="imgProduto" id="customFileLang" name="imagemProduto" lang="pt-BR" style="background-color:  #FF7804;float: right;" type="file" class="custom-file-input">
				</div>
				<div class="form-group">
					<label  for="nomeProduto"> Nome: </label>
					<input required="required" class="form-control" type="text" id="nomeProduto" name="nomeProduto" placeholder="Nome do Produto...">
				</div>
				<div class="form-group">
					<label  for="precoProduto"> Pre�o: </label>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text" id="inputGroupPrepend3">R$</span>
						</div>
						<input required="required" class="form-control" type="text" id="precoProduto" name="precoProduto" placeholder="0,00">
					</div>
				</div>
				<div class="form-group">
					<label  for="marcaProduto"> Marca: </label>
					<input required="required" class="form-control" type="text" id="marcaProduto" name="marcaProduto" placeholder="Marca do Produto...">
				</div>
				<div class="form-group">
					<label  for="fornecedorProduto"> Fornecedor: </label>
					<input required="required" class="form-control" type="text" id="fornecedorProduto" name="fornecedorProduto" placeholder="Nome do Fornecedor...">
				</div>
				<div class="form-group">
					<label  for="categoriaProduto"> Categoria: </label>
					<select required="required" class="form-control" name="categoriaProduto" id="categoriaProduto"> 
						<option selected disabled value=""> Selecione aqui: </option>
						<option value="Academia"> Academia </option>
						<option value="Basquete"> Basquete </option>
						<option value="Ciclismo"> Ciclismo </option>
						<option value="Corrida"> Corrida </option>
						<option value="Futebol"> Futebol </option>
						<option value="Nata��o"> Nata��o </option>
						<option value="T�nis"> T�nis </option>
						<option value="V�lei"> V�lei </option>
					</select> 
				</div>
				<div class="form-group">
					<label  for="subcategoriaProduto">Subcategoria: </label>
					<select required="required" class="form-control" name="subcategoriaProduto" id="subcategoriaProduto"> 
						<option selected disabled value=""> Selecione aqui: </option>
						<option value="Acess�rios"> Acess�rios </option>
						<option value="Equipamentos"> Equipamentos </option>
						<option value="Vestimentas"> Vestimentas </option>
					</select>
				</div>
				<div class="form-group">
					<label  for="descricaoProduto"> Descri��o: </label>
					<textarea style="resize: none;" rows="10" cols="30" required="required" class="form-control" id="descricaoProduto" name="descricaoProduto" maxlength="680" placeholder="Descri��o do Produto..."></textarea>
				</div>
				<button id="botCad" style="float: right; background-color: #FF7804; border-color: #CC5F02;" type="submit" class="btn btn-primary mb-2" >Cadastrar Produto <i class="fa fa-plus-circle" aria-hidden="true"></i></button>
			</form>
		</div>
		<script type="text/javascript">
			$('#precoProduto').mask('000.000.000,00', {reverse: true});
		</script>
	</div>
	
		<div class="R">
		<div class="rodape" >
	<div class="institucional"><br>
		<h4 style="color: #FF7804;">INSTITUCIONAL</h4>
<a href="" class="a">Sobre N�s</a><br><br>
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
<div id="aa" style="text-align: left;"><img src="imagens/relogio.png" style="position:relative;width: 23px;	height: 23px;top: 5px;"><b> HOR�RIOS DE ATENDIMENTO</b><br><br>
<a style="font-size:13px; color: white;">SEG - SEX das 9:00 �S 18:00<br>SAB DAS 9:00 �S 13:30<br>Exceto feriados</a></div><br><br>

	</div>
	<div class="midia"><br>
		<h4 style="color: #FF7804;">M�DIAS SOCIAIS</h4>
<a href="" class="a" id="a"><img style="position: relative;width: 23px;height: 23px; top:5px;" src="imagens/instagram.png"> INSTAGRAM</a><br><br>
<a href="" class="a" id="a"><img style="position:relative; width: 23px;height: 23px; top:5px;" src="imagens/facebook.png"> FACEBOOK</a><br><br>
	</div>
	<div class="politica"><br>
		<h4 style="color: #FF7804;">POL�TICAS DA LOJA</h4>
<a href="" class="a">Pol�ticas de Troca e Devolu��o</a><br><br>
<a href="" class="a">Pol�ticas de Frete</a><br><br>
<a href="" class="a">Pol�ticas de Garantia</a><br><br>
<a href="" class="a">Fale Conosco</a>
		<br>
		<h4 style="color: #FF7804;">FORMAS DE PAGAMENTO</h4>
		<div class="pagamento"><a href=""><img style="width: 295px;height: 97px;" src="imagens/cartao.png"></a></div>
	</div>
</div>

<div class="rodape1"><div style="padding: 12px 0 12px; color: white;text-align: center; font-size: 13px;">SANBEL COMERCIO VAREJISTA DE ARTIGOS ESPORTIVOS LTDA - CNPJ: 37.012.345/6789-37<br> � Todos os direitos reservados. 2021<br><br>Empresa Fict�cia com produtos, imagens e comprovantes meramente ilustrativos.</div></div>
		</div>
	</body>
</html>