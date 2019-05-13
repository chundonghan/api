$(function(){
	csrf();
	getSystemInfoList(1);
});
// 防止跨站请求伪造
function csrf(){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});
}

function getSystemInfoList(page) {
	var _system_container = document.getElementById('system-container');
	var childs = _system_container.childNodes;
    for (var i = childs.length - 1; i >= 0; i--) {
    	_system_container.removeChild(childs[i]);
    }
	var _page_num = 8;
	$.ajax({
		type : 'POST',
		url : getPath()+'/hall/system/list',
		data : {
			currentPage : page,
			pageNum : _page_num
		},
		// contentType:'application/json',
		dataType : 'json',
		success : function(data) {
			if(data){
				var _system_list = data.list;
				var _total_page = data.totalPage;
				createSystemItem(_system_container,_system_list);
				
				var page_ele = document.getElementById('pagination');
				pagination.paging(getSystemInfoList,page_ele, page, _total_page, _page_num);
			}
		},
		error : function(e) {
			console.log(e);

		}
	});

}
function createSystemItem(parent_ele,data){
	for(var i = 0;i < data.length; i ++){
		var _div_system_item = document.createElement('div');
		_div_system_item.className = 'system-item col-5 col-md-4 col-lg-3 col-xl-3';
		var _div_box = document.createElement('div');
		_div_box.className = 'box box-body';
		_div_box.dataset.url = data[i].SYSTEM_URL;
		_div_box.addEventListener('click',function(e){
			var _url = this.dataset.url;
			window.open(getPath()+_url,'_self');
		});
		var _div = document.createElement('div');
		_div.className = 'text-center pt-3';
		var _img = document.createElement('img');
		_img.className = 'avatar avatar-lg';
		_img.setAttribute('src',getPath()+(data[i].SYSTEM_ICON==undefined?'/images/avatar/8.jpg':data[i].SYSTEM_ICON));
		var _div_title = document.createElement('div');
		_div_title.className = 'mt-15 mb-0 title';
		_div_title.innerText = data[i].SYSTEM_NAME;
		
		_div.appendChild(_img);
		_div.appendChild(_div_title);
		_div_box.appendChild(_div);
		_div_system_item.appendChild(_div_box);
		parent_ele.appendChild(_div_system_item);
	}
}


function getPath(){
    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0,index+1);
    return result;
}

function logout(){
	var token = $("meta[name='_csrf']").attr("content");
	var parameter = $("meta[name='_csrf_parameter']").attr("content");
	var tempForm = document.createElement("form");
    tempForm.method="post";
	tempForm.target="_self";
    tempForm.action=getPath()+"/logout";
          
    var hideInput = document.createElement("input");
    hideInput.type="hidden";
    hideInput.name= parameter;
    hideInput.value= token;
    tempForm.appendChild(hideInput);
	
	document.body.appendChild(tempForm);   
    tempForm.submit();
    document.body.removeChild(tempForm);
}
