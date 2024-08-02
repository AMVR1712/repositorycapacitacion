<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<!-- Etiquetas Struts y javaScript -->
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>CRUD</title>
</head>
<s:head/>
<sx:head/>
<body>

<sx:tabbedpanel id="formuserCap">
	<sx:div label="Formulario CRUD UserCap">
		<s:form action="alta.action" method="post">
			<s:push value="userCap">
				<s:hidden key="id"/>
				<s:textfield key="nombre" label="Nombre"/>
				<s:radio name="genero" label="Genero" list="#{'Masculino' : 'M', 'Femenino' : 'F'}"/>
				<s:select name="ciudad" label="Ciudad" list="#{'Pue' : 'Puebla', 'Mor' : 'Morelos', 'Tlax' : 'Tlaxcala', 'Ver' : 'Veracruz'}" headerKey="1" headerValue="Selecciona Ciudad"/>
				<s:textarea key="descripcion" label="Descripcion"/>
				<s:checkbox name="desarrollador" label="Tiene experiencia en desarrollo web?"/>
				<s:submit value="Aceptar"/>
				<s:reset value="Limpiar"/>
			</s:push>
		</s:form>
	</sx:div>
</sx:tabbedpanel>

<table>
	<tr>
		<td>ID</td>
		<td>Nomnbre</td>
		<td>Genero</td>
		<td>Ciudad</td>
		<td>Descripcion</td>
		<td>Desarrollador</td>
		<td>Acciones</td>
	</tr>
	<s:iterator value="listaUserCap">
		<tr>
			<td><s:property value="id"/></td>
			<td><s:property value="nombre"/></td>
			<td><s:property value="genero"/></td>
			<td><s:property value="ciudad"/></td>
			<td><s:property value="descripcion"/></td>
			<td><s:property value="desarrollador"/></td>
			<td>
				<s:url id="editURL" action="editar">
					<s:param name="id" value="%{id}"/>
				</s:url>
				<s:a href="%{editURL}">Editar</s:a>
			</td>
			<td>
				<s:url id="eliminarURL" action="baja">
					<s:param name="id" value="%{id}"/>
				</s:url>
				<s:a href="%{eliminarURL}">Eliminar</s:a>
			</td>
		</tr>
	</s:iterator>
</table>

</body>
</html>