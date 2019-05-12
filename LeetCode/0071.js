//在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录
var simplifyPath = function(path) {
    var arr = path.split('/');//split
    var result = [];
    
    for(var i = 0; i < arr.length; i++) {
        var p = arr[i];
        if(p === '..') {
            result.pop();//pop() 方法用于删除并返回数组的最后一个元素。
        } else if(p !== '' && p !== '.') {
            result.push(p);//push() 方法可向数组的末尾添加一个或多个元素，并返回新的长度。
        }
    }
    
    return '/' + result.join('/');
};
