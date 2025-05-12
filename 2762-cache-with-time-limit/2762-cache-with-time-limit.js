class TimeLimitedCache {
  constructor() {
    this.cache = new Map();
  }

  set(key, value, duration) {
    const found = this.cache.has(key);

    if (found) {
      clearTimeout(this.cache.get(key).timerId);
    }

    this.cache.set(key, {
      value,
      value,
      timerId: setTimeout(() => {
        this.cache.delete(key);
      }, duration),
    });

    return found;
  }

  get(key) {
    return this.cache.has(key) ? this.cache.get(key).value : -1;
  }

  count() {
    return this.cache.size;
  }
}