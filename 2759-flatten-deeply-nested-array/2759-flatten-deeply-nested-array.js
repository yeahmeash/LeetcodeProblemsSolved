/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
/**
 * @param {Array} arr
 * @param {number} n
 * @return {Array}
 */
var flat = function(arr, n) {
    if (n === 0) {
        return arr.slice(); // Return a shallow copy to avoid modifying the original array
    }
    let result = [];
    for (const element of arr) {
        if (Array.isArray(element) && n > 0) {
            result.push(...flat(element, n - 1));
        } else {
            result.push(element);
        }
    }
    return result;
};