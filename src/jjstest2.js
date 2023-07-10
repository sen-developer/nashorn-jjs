// var foo = function (args){
//     var list = [1, 2, 3, 4, 5];
//     var result = '';
//     for each (var i in list) {
//     result+=i+'-';
//     };
//     return result;
// }
var getHello = function (name){
    return "Hello dr. " + name;
}
// console.log(foo([5, 4, 7, 8]));

var arrayToJavaArrayList = function (arr) {
    var ArrayList = Java.type('java.util.ArrayList')
    var list = new ArrayList();
    for (var i = 0; i < arr.length; i++) {
        list.add(arr[i])
    }
    // arr.forEach(item=>list.add(item))
    return list;
}
var arrayToJavaArray = function (arr){

    var sum = arr[1];
    for (var i = 1; i < arr.length; i++) {
        sum+=',' + arr[i];
    }
    return sum;
}
