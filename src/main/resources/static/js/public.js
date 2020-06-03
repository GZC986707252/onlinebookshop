layui.use(['element', 'jquery', 'layer', 'laytpl','laypage','form'], function() {
	var $ = layui.jquery,
		layer = layui.layer,
		laytpl = layui.laytpl,
		laypage=layui.laypage,
		form=layui.form,
		element = layui.element;
		
		
	//订单信息填写弹窗,并提交订单
	/**
	 * 参数data的要求[{'cartId':'','bookId':'','price':'','quantity':''}]
	 * @param {Object} data
	 */
	window.order_submit_popup=function(data){
		var form_str='<form class="layui-form" lay-filter="orderVal"> '
			 + '<div class="layui-form-item"> '
			   + '<label class="layui-form-label">收货人</label> '
			  + ' <div class="layui-input-block"> '
			 + '<input type="text" name="consigneeName" required  lay-verify="required" placeholder="请输入收货人姓名" autocomplete="off" class="layui-input"></div> '
			 + '</div><div class="layui-form-item layui-form-text"> '
			  +  '<label class="layui-form-label">收货地址</label><div class="layui-input-block"> '
			  + '<textarea name="address" placeholder="请输入收货地址" class="layui-textarea"></textarea>'
			  +'</div></div><div class="layui-form-item"> '
			   + '<label class="layui-form-label">邮政编号</label><div class="layui-input-block"> '
			   +   '<input type="text" name="zip" required  lay-verify="required" placeholder="请输入邮政编号" autocomplete="off" class="layui-input"> '
			  +'</div></div><div class="layui-form-item"> '
			   + '<label class="layui-form-label">手机号码</label><div class="layui-input-block"> '
			   + '<input type="text" name="phoneNumber" required  lay-verify="required" placeholder="请输入手机号码" autocomplete="off" class="layui-input"> '
			   + '</div></div>';
		
		layer.open({
			type:0 ,
			title: '订单信息提交',
			content: form_str,
			area: ['500px'],
			btn: ['提交订单','取消'],
			btnAlign: 'c',
			yes:function(index){
				var order_data=form.val("orderVal");
				console.log(order_data);
				console.log(data);
				//ajax
			},
			btn2:function(index){
				layer.close(index);
			},
			success:function(){
				form.render();
			}
		});     
	}
	
});