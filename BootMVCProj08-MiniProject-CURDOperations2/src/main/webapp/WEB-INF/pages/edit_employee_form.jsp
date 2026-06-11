<%@ page isELIgnored="false"  %>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="frm"   %>


<h1  style="color:green;text-align:center"> Edit Employee Form Page  </h1>

<frm:form    modelAttribute="emp">
  <table border="1" bgcolor="cyan" align="center">
     <tr>
        <td> No:: </td>
        <td> <frm:input path="empno"  readonly="true"/> </td>
     </tr>
     
     <tr>
        <td> Name:: </td>
        <td> <frm:input path="ename"/> </td>
     </tr>
      <tr>
        <td> Address:: </td>
        <td> <frm:input path="eaddrs"/> </td>
     </tr>
   <tr>
        <td> Desg:: </td>
        <td> <frm:input path="desg"/> </td>
     </tr>
      <tr>
        <td> Salary:: </td>
        <td> <frm:input path="salary"/> </td>
     </tr>
      <tr>
        <td> <input type="submit"  value="Edit Employee"> </td>
        <td> <input type="reset"  value="cancel"/> </td>
     </tr>
    </table>

</frm:form>
