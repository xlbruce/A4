<%-- 
    Document   : index
    Created on : 30/10/2015, 17:27:40
    Author     : bruce
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" media="screen" href="css/style.css"/>
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="js/bootstrap.js"></script>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pets page</title>
    </head>
    <body>
        <jsp:useBean id="consumer" class="controller.PetsReceiver"/>
        <c:set var="pets" value="${consumer.getPetsList('http://pedrocacique.com/lp3/getAllPets/')}"/>
        <div class="container">
            <c:forEach items="${pets}" var="pet">
                <div class="cachorro">
			<div class="titulo">${pet.name}</div>
                        <div class="imagem"><img src="${pet.photo}" width="100px" height="100px"/></div>
			<div class="texto">
				<div class="raca">${pet.race} - ${pet.age}</div>
				<div class="descricao">${pet.description}</div>
			</div>
			<div class="localidade">${pet.city} - ${pet.country.name}</div>
		</div>
                </c:forEach>
            </div>
            
        </div>        
    </body>
</html>
