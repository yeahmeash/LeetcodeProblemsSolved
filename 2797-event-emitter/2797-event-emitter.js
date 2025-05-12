class EventEmitter {
  constructor() {
    this.events = new Map();
  }

  subscribe(eventName, callback) {
    if (!this.events.has(eventName)) {
      this.events.set(eventName, []);
    }

    const events = this.events.get(eventName);
    events.push(callback);

    return {
      unsubscribe: () => {
        const index = events.indexOf(callback);
        if (index !== -1) {
          events.splice(index, 1);
        }
      },
    };
  }

  emit(eventName, args = []) {
    if (!this.events.has(eventName)) {
      return [];
    }

    const result = [];
    const events = this.events.get(eventName);

    events.forEach((callback) => {
      result.push(callback(...args));
    });

    return result;
  }
}