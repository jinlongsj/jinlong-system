window.CollectUtil = (function($, module) {

	/**
	 * 实现map对象 
	 */
	function Map() {
		
		/** 存放键的数组(遍历用到) */
		this.keys = new Array();
		
		/** 存放数据 */
		this.data = new Object();

		/**
		 * 放入一个键值对
		 * 
		 * @param {String}
		 *            key
		 * @param {Object}
		 *            value
		 */
		this.put = function(key, value) {
			if (this.data[key] == null) {
				this.keys.push(key);
			}
			this.data[key] = value;
		};

		/**
		 * 获取某键对应的值
		 * 
		 * @param {String}
		 *            key
		 * @return {Object} value
		 */
		this.get = function(key) {
			return this.data[key];
		};

		/**
		 * 删除一个键值对
		 * 
		 * @param {String}
		 *            key
		 */
		this.remove = function(key) {
			this.keys.pop(key);
			this.data[key] = null;
		};

		/**
		 * 遍历Map,执行处理函数
		 * 
		 * @param {Function}
		 *            回调函数 function(key,value,index){..}
		 */
		this.each = function(fn) {
			if (typeof fn != 'function') {
				return;
			}
			var len = this.keys.length;
			for (var i = 0; i < len; i++) {
				var k = this.keys[i];
				fn(k, this.data[k], i);
			}
		};

		/**
		 * 获取键值数组(类似Java的entrySet())
		 * 
		 * @return 键值对象{key,value}的数组
		 */
		this.entrys = function() {
			var len = this.keys.length;
			var entrys = new Array(len);
			for (var i = 0; i < len; i++) {
				entrys[i] = {
					key : this.keys[i],
					value : this.data[i]
				};
			}
			return entrys;
		};

		/**
		 * 判断Map是否为空
		 */
		this.isEmpty = function() {
			return this.keys.length == 0;
		};

		/**
		 * 获取键值对数量
		 */
		this.size = function() {
			return this.keys.length;
		};

		/**
		 * 重写toString
		 */
		this.toString = function() {
			var s = "{";
			for (var i = 0; i < this.keys.length; i++, s += ',') {
				var k = this.keys[i];
				s += k + "=" + this.data[k];
			}
			s += "}";
			return s;
		};
	}

	/**
	 * 实现list集合 
	 */
	function List(array) {

		if (array) {
			this.value = array;
		} else {
			this.value = [];
		}

		/* 添加 */
		this.add = function(obj) {
			return this.value.push(obj);
		};
		
		/* 大小 */
		this.size = function() {
			return this.value.length;
		};
		
		/* 返回指定索引的值 */
		this.get = function(index) {
			return this.value[index];
		};
		
		/* 删除指定索引的值 */
		this.remove = function(index) {
			this.value.splice(index, 1);
			return this.value;
		};
		
		/* 删除全部值 */
		this.removeAll = function() {
			return this.value = [];
		};
		
		/* 是否包含某个对象 */
		this.constains = function(obj) {
			for ( var i in this.value) {
				if (obj == this.value[i]) {
					return true;
				} else {
					continue;
				}
			}
			return false;
		};

		/**
		 * 获得集合众的所有信息 
		 */
		this.getAll = function() {
			var allInfos = '';
			for ( var i in this.value) {
				if (i != (value.length - 1)) {
					allInfos += this.value[i] + ",";
				} else {
					allInfos += this.value[i];
				}
			}
			jAlert(allInfos, "提示");
			return allInfos += this.value[i] + ",";;
		};

	}

	module.Map = Map;
	module.List = List;

	return module;
})($, window.CollectUtil || {});


