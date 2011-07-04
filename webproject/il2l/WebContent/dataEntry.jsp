<%-- 
    Document   : dataEntry
    Created on : Jun 25, 2011, 1:50:46 AM
    Author     : Narayanan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            .hide {
                display: None;
                background-color: #C7FECA;
            }
            .table-top {
                border-top:outset 2px;
                border-right:outset 2px;
                border-left:outset 2px;
                border-color: #666;
            }
            .table-middle{
                border-left:outset 2px;
                border-right:outset 2px;
                border-color: #666;
            }
            .table-bottom{
                border-left:outset 2px;
                border-right:outset 2px;
                border-bottom:outset 2px;
                border-color: #666;
            }
        </style>
        <script language="JavaScript">
            function showhide(val)
            {
                var checkbox="chk"+val;
                var d="div"+val;
                if(document.getElementById(checkbox).checked==true)
                {
                    document.getElementById(d).style.display="block";
                }
                else
                {
                    document.getElementById(d).style.display="none";
                }
            }
        </script>
    </head>
    <body>
        <h1 align="center">Add question</h1>
        <form action="addQuestion.jsp" enctype="multipart/form-data">
            <table width="356" align="center" class="table-top">
                <thead>
                    <tr bgcolor="#D6D6D6">
                        <th colspan="2" align="left" bgcolor="#D6D6D6">Subject Details</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td width="124">Subject Name</td>
                        <td width="218"><input type="text" name="sub"/></td>
                    </tr>
                    <tr>
                        <td>Module Name</td>
                        <td><input type="text" name="mod"/></td>
                    </tr>
                    <tr>
                        <td>Sub-Module Name</td>
                        <td><input type="text" name="submod"/></td>
                    </tr>
                </tbody>
            </table>

            <table width="356" align="center" class="table-middle">
                <thead>
                    <tr bgcolor="#D6D6D6">
                        <th colspan="2" align="left">Question Details</th>
                    </tr>
                </thead>
                <tr>
                    <td width="124">Appearance</td>
                    <td width="218"><input type="checkbox" name="1" id="chk1" onClick="showhide(1);"> Appearance 1<br/>
                        <div id="div1" class="hide">
                            Month & Year: <select name="month1">
                                <option value="1">Jan</option>
                                <option value="2">Feb</option>
                                <option value="3">Mar</option>
                                <option value="4">Apr</option>
                                <option value="5">May</option>
                                <option value="6">Jun</option>
                                <option value="7">Jul</option>
                                <option value="8">Aug</option>
                                <option value="9">Sep</option>
                                <option value="10">Oct</option>
                                <option value="11">Nov</option>
                                <option value="12">Dec</option>
                            </select>&nbsp;&nbsp;
                            <input type="text" name="year1" value="2001" size="5" maxlength="4"/> <br/>
                            Marks : <input type="text" name="marks1" size="3" maxlength="2"/>
                        </div>

                        <input type="checkbox" name="2" id="chk2" onClick="showhide(2);"> Appearance 2<br/>
                        <div id="div2" class="hide">
                            Month & Year: <select name="month2">
                                <option value="1">Jan</option>
                                <option value="2">Feb</option>
                                <option value="3">Mar</option>
                                <option value="4">Apr</option>
                                <option value="5">May</option>
                                <option value="6">Jun</option>
                                <option value="7">Jul</option>
                                <option value="8">Aug</option>
                                <option value="9">Sep</option>
                                <option value="10">Oct</option>
                                <option value="11">Nov</option>
                                <option value="12">Dec</option>
                            </select>&nbsp;&nbsp;
                            <input type="text" name="year2" value="2001" size="5" maxlength="4"/> <br/>
                            Marks : <input type="text2" name="marks" size="3" maxlength="2"/>
                        </div>

                        <input type="checkbox" name="3" id="chk3" onClick="showhide(3);"> Appearance 3<br/>
                        <div id="div3" class="hide">
                            Month & Year: <select name="month3">
                                <option value="1">Jan</option>
                                <option value="2">Feb</option>
                                <option value="3">Mar</option>
                                <option value="4">Apr</option>
                                <option value="5">May</option>
                                <option value="6">Jun</option>
                                <option value="7">Jul</option>
                                <option value="8">Aug</option>
                                <option value="9">Sep</option>
                                <option value="10">Oct</option>
                                <option value="11">Nov</option>
                                <option value="12">Dec</option>
                            </select>&nbsp;&nbsp;
                            <input type="text" name="year3" value="2001" size="5" maxlength="4"/> <br/>
                            Marks : <input type="text" name="marks3" size="3" maxlength="2"/>
                        </div>

                        <input type="checkbox" name="4" id="chk4" onClick="showhide(4);"> Appearance 4<br/>
                        <div id="div4" class="hide">
                            Month & Year: <select name="month4">
                                <option value="1">Jan</option>
                                <option value="2">Feb</option>
                                <option value="3">Mar</option>
                                <option value="4">Apr</option>
                                <option value="5">May</option>
                                <option value="6">Jun</option>
                                <option value="7">Jul</option>
                                <option value="8">Aug</option>
                                <option value="9">Sep</option>
                                <option value="10">Oct</option>
                                <option value="11">Nov</option>
                                <option value="12">Dec</option>
                            </select>&nbsp;&nbsp;
                            <input type="text" name="year4" value="2001" size="5" maxlength="4"/> <br/>
                            Marks : <input type="text" name="marks4" size="3" maxlength="2"/>
                        </div></td>
                </tr>
                <tr>
                    <td>Question</td>
                    <td><textarea cols="20" rows="4"></textarea></td>
                </tr>

                <tr>
                    <td>Question Image</td>
                    <td><input type="file" name="quesUpload" value="" /></td>

                </tr>
            </table>
            <table width="356" align="center" class="table-bottom">
                <thead>
                    <tr bgcolor="#D6D6D6">
                        <th colspan="2" align="left">Answer Details</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td width="124">Answer</td>
                        <td width="218"><textarea cols="20" rows="4"></textarea></td>
                    </tr>
                    <tr>
                        <td>Answer Image</td>
                        <td><input type="file" name="quesUpload" value="" /></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center" style="padding: 7px"><input type="submit" name="submit" value="Upload Question"> &nbsp;&nbsp;<input type="reset" name="reset" value="Reset"></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
