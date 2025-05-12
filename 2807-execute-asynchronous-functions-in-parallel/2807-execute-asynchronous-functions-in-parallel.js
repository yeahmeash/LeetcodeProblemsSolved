/**
 * @param {Array<Function>} functions
 * @return {Promise<any>}
 */
/**
 * @param {Array<Function>} functions
 * @return {Promise<any[]>}
 */
var promiseAll = function(functions) {
    return new Promise((resolve, reject) => {
        if (functions.length === 0) {
            resolve([]);
            return;
        }
        
        const results = new Array(functions.length);
        let resolvedCount = 0;
        
        functions.forEach((fn, index) => {
            fn().then(value => {
                results[index] = value;
                resolvedCount++;
                if (resolvedCount === functions.length) {
                    resolve(results);
                }
            }).catch(reason => {
                reject(reason);
            });
        });
    });
};

/**
 * const promise = promiseAll([() => new Promise(res => res(42))])
 * promise.then(console.log); // [42]
 */