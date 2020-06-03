layui.use(['element', 'jquery', 'layer', 'laytpl','laypage','form'], function() {
	var $ = layui.jquery,
		layer = layui.layer,
		laytpl = layui.laytpl,
		laypage=layui.laypage,
		form=layui.form,
		element = layui.element;
		

		getShoppingCart();
		function getShoppingCart(){
			var queryStr=window.location.search;
			var userId=queryStr.substring(queryStr.lastIndexOf("=")-1);
			//获取用户购物车信息
			$.getJSON("../static/api/shopping_cart.json",function(res){
				if(res.code!=0){
					$("#shopping-carts").append('<div class="cart-tip">你的购物车空空如也~快去剁剁手吧</div>');
					$("#buyBtn").hide();
					$("#clearBtn").hide();
					return ;
				}
				laytpl($("#shopping-carts-tpl").html()).render(res.data,function(html){
					$("#shopping-carts").append(html);
				});
				form.render('checkbox');
			});
		}
		
		
		//监听全选复选
		form.on('checkbox(selectAll)', function(data){
			
			if(data.elem.checked){
				//全选
				$.each($("input[name='cartId']"),function(index,item){
					$(item)[0].checked=true;
				});
				form.render('checkbox');
			}else{
				//取消全选
				$.each($("input[name='cartId']"),function(index,item){
					$(item)[0].checked=false;
				});
				form.render('checkbox');
			}
		}); 
		//监听除全选以外的复选框
		form.on('checkbox(selectOne)', function(data){
			var flag=true;
			$.each($("input[name='cartId']"),function(index,item){
				if(!$(item)[0].checked){
					flag=false;
				}
			});
			if(flag){
				$("input[name='selectAll']")[0].checked=true;
			}else{
				$("input[name='selectAll']")[0].checked=false;
			}
			form.render('checkbox');
		}); 
		
		
		//立即购买按钮
		$("#buyBtn").click(function(){
			let data=[];
			//获取选中的商品
			$.each($("input[name='cartId']"),function(index,item){
				let cartItem={};  //构造数据
				if($(item)[0].checked){
					//获取选中复选框的属性
					let cartId=$(item).val();
					cartItem['cartId']=cartId;
					//书籍ID
					cartItem['bookId']=$(item).attr("c-bookId");
					//价格
					cartItem['price']=$(item).attr("c-price");
					//购买数量
					cartItem['quantity']=$("#quantity-"+cartId).val();
					data.push(cartItem);
				}
			});
			order_submit_popup(data);
			console.log(data);
		});
		
		
		//清空购物车按钮
		$("#deleteSelectedBtn").click(function(){
			let data=[];
			$.each($("input[name='cartId']"),function(index,item){
				var cartItem={};  //构造数据
				if($(item)[0].checked){
					//获取选中复选框的属性
					data.push($(item).val());
				}
			});
			layer.msg(JSON.stringify(data));
		});
		
		/**
		 * 购物车输入框的输入验证和计算总金额
		 * @param {Object} obj 输入框对象
		 * @param {Object} cartId
		 * @param {Object} price
		 */
		window.checkAndCalculate=function(obj,cartId,price){
			var qty=$(obj).val();
			console.log("1");
			
			if(qty<0){
				layer.msg("购买数量必须大于或者等于0");
			}
			if(qty==''){
				$(obj).val(0);
			}
			$("#total-"+cartId).text(calculate(price,qty));
		}
		
		//删除单个购物车
		window.deleteByCartId=function(cartId){
			layer.msg("删除"+cartId);
			//重新ajax渲染页面的购物车信息
		}
		
		/**
		 * 计算总价格
		 * @param {Object} price
		 * @param {Object} quantity
		 */
		window.calculate=function(price,quantity){
			return Math.floor(parseFloat(price*100 *quantity))/100;
		}
});