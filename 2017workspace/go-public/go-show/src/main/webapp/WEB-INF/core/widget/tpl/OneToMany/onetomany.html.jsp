<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%@ taglib uri="/fis" prefix="fis"%>
	
<fis:require id="core:widget/tpl/OneToMany/onetomany.js" />    
<div id="layoutObj"></div>
<script type="text/javascript">

GLOBAL.P.MODULES="${P_TPL_MODULES}";
GLOBAL.P.CLASSNAME="${P_CLASS_NAME}";
GLOBAL.P.CLASS="${P_CLASS}";
GLOBAL.P.MAXIMIZED=false;

GLOBAL.P.P_GRID_HEADER="${P_GRID_HEADER}";
GLOBAL.P.P_GRID_COLUMNIDS="${P_GRID_COLUMNIDS}";
GLOBAL.P.P_GRID_WIDTH="${P_GRID_WIDTH}";
GLOBAL.P.P_GRID_COLALIGN="${P_GRID_COLALIGN}";
GLOBAL.P.P_GRID_COLTYPES="${P_GRID_COLTYPES}";
GLOBAL.P.P_GRID_COLSORTING="${P_GRID_COLSORTING}";
GLOBAL.P.P_GRID_VALIDATORS=${P_GRID_VALIDATORS};
GLOBAL.P.P_GRID_FORMGRIDASSEMBLE=${P_GRID_FORMGRIDASSEMBLE};

GLOBAL.P.P_SIMPLE_QUERY_NAMES=${P_SIMPLE_QUERY_NAMES};
GLOBAL.P.P_SIMPLE_QUERY_VALUES=${P_SIMPLE_QUERY_VALUES};
GLOBAL.P.P_SIMPLE_QUERY_OPERATOR=${P_SIMPLE_QUERY_OPERATOR};
GLOBAL.P.P_SIMPLE_QUERY_FORM_TYPE=${P_SIMPLE_QUERY_FORM_TYPE};

GLOBAL.P.P_FORM=${P_FORM};

GLOBAL.P.P_SUB_INFO=${P_SUB_INFO};
</script>