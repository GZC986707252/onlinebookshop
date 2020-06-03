layui.use(['element', 'jquery', 'layer', 'laytpl','laypage','form','table'], function() {
	var $ = layui.jquery,
		layer = layui.layer,
		laytpl = layui.laytpl,
		laypage=layui.laypage,
		form=layui.form,
		element = layui.element,
		table = layui.table;
		
		//从url路径中获取书籍ID
		var str=window.location.pathname;
		var bookId=str.substring(str.lastIndexOf("/")+1);

		//立即购买提交按钮
		$("#buyNowBtn").click(function(){
			let data=[];
			let quantity=$("#quantity").val();
			let price=$("#price").text();
			data.push({
				'cartId':null,
				'bookId':bookId,
				'price':price,
				'quantity':quantity
			});
			console.log(data);
			order_submit_popup(data);
			
		});
		
		//添加购物车提交按钮
		$("#addCartBtn").click(function(){
			let quantity=$("#quantity").val();
			let price=$("#price").text();
			let data={
				'bookId':bookId,
				'price':price,
				'quantity':quantity
			};
			console.log(data);
		});
		
		
		
		//购买数量输入框监听
		window.check=function(obj,price){
			var qty=$(obj).val();
			if(qty<0||qty==''){
				layer.msg("输入必须大于或者等于0");
				$(obj).val(0);
				qty=0;
			}
			if(qty>10){
				layer.msg("每个用户限购10件");
				$(obj).val(10);
				qty=10;
			}
			$("#totalAccount").text("¥"+Math.floor(parseFloat(price*100 *qty))/100);
		}
});