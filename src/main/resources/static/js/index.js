layui.use(['element', 'jquery', 'layer', 'laytpl','laypage'], function() {
	var $ = layui.jquery,
		layer = layui.layer,
		laytpl = layui.laytpl,
		laypage=layui.laypage,
		element = layui.element;
	
	//鼠标悬停在图片上的样式
	$(".book-card a img").hover(function(){
		$(".book-card .name a").addClass("img-hover");
	},function(){
		$(".book-card .name a").removeClass("img-hover");
	});
		
		
	//请求加载分类信息
	$.getJSON("../static/api/category.json",function(res){
		if(res.code!=0){
			$("#content").html(result.msg);
			return ;
		}
		$.each(res.data,function(index,item){
			let str='<li c-code="'+item.categoryCode+'">'+item.categoryName+'</li>';
			$("#category_tag").append(str);
		});
		$.getJSON("../static/api/book.json",function(result){
			if(result.code!=0){
				$("#content").html(result.msg);
				return ;
			}
			laytpl($("#book-card-tpl").html()).render(result.data,function(html){
				$("#content").html(html);
			});
		});
	});
	
	

	/**
	 * 监听切换分类选项卡的切换
	 */
	element.on('tab(categoryTabBrief)', function(data) {
		// console.log($(this).attr("c-code")); //当前Tab标题所在的原始DOM元素
		//ajax
	});
	
	//搜索
	$("#search-btn").click(function(){
		let keyword=$("#keyword-input").val();
		if(keyword.length==0){
			return;
		}
		layer.msg(keyword);
	});


	//调用分页
	  laypage.render({
	    elem: 'page-util'
	    ,count: 100
	    ,jump: function(obj,first){
		  
	      console.log(obj);
		 }
	  });

});
