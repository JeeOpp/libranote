
const NotFound = { template: '<p>Страница не найдена</p>' }
const Home = { template: '<p>главная</p>' }
const About = { template: '<p>о нас</p>' }

const routes = {
  '/': Home,
  '/about': About
}

new Vue({
  el: '#app',
  data: {
    currentRoute: window.location.pathname
  },
  computed: {
    ViewComponent () {
      return routes[this.currentRoute] || NotFound
    }
  },
  render (h) { return h(this.ViewComponent) }
})

var todoComponent = {
    props: {
        item: Object,
        index: Number
    },
    data: function(){ //DATA у таких компонентов должна быть функцией!!!!!!
            return{
                fontSize: 2
            }
    },
    template: '<li>\
        <input v-model="item.text"/>\
        <span :title="index" :style="{fontSize: fontSize + \'em\'}">{{ item.text }}</span>\
        <button @click="fontSize++">+</button>\
        <button @click="fontSize--">-</button>\
        <button @click="$emit(\'remove\')">Удалить</button>\
        <slot></slot>\
    </li>'
}
//emit типа вызывает метод родителя
var app1 = new Vue({
   el: '#app1',
   data: {
       message: 'Hello Vue.js!',
       seen: true,
       todos:[
           {id: 0, text: "first"},
           {id: 1, text: "second"},
           {id: 2, text: "third"}
       ],
       timeNow: null,
       timerID: null
   },
   computed:{
       reversedMessage: function(){
           return this.message.split('').reverse().join('')
       }
   },
   created: function () {
       this.timerID = setInterval(() => this.timeTimer(), 1000)
   },
   methods: {
       deleteMessage: function(){
           this.message = ''
       },
       addTodo: function(){
           this.todos.push({id: this.message, text: this.message})
       },
       timeTimer: function(){
           this.timeNow = new Date().toLocaleString('ru', {
                                  year: 'numeric',
                                  month: 'long',
                                  day: 'numeric',
                                  hour: 'numeric',
                                  minute: 'numeric',
                                  second: 'numeric'
                                });
       }
   },
   components: {
       'todo-item': todoComponent
   }
})

var watchExampleVM = new Vue({
  el: '#watch-example',
  data: {
    question: '',
    answer: 'Пока вы не зададите вопрос, я не могу ответить!',
    image: null,
    imageSeen: false
  },
  watch: {
    // эта функция запускается при любом изменении вопроса
    question: function (newQuestion, oldQuestion) {
      this.answer = 'Ожидаю, когда вы закончите печатать...'
      this.imageSeen = false
      this.debouncedGetAnswer()
    }
  },
  created: function () {
    // _.debounce — это функция lodash, позволяющая ограничить то,
    // насколько часто может выполняться определённая операция.
    // В данном случае мы ограничиваем частоту обращений к yesno.wtf/api,
    // дожидаясь завершения печати вопроса перед отправкой ajax-запроса.
    // Узнать больше о функции _.debounce (и её родственнице _.throttle),
    // можно в документации: https://lodash.com/docs#debounce
    this.debouncedGetAnswer = _.debounce(this.getAnswer, 500)
  },
  methods: {
    getAnswer: function () {
      if (this.question.indexOf('?') === -1) {
        this.answer = 'Вопросы обычно заканчиваются вопросительным знаком. ;-)'
        return
      }
      this.answer = 'Думаю...'
      var vm = this
      axios.get('https://yesno.wtf/api')
        .then(function (response) {
          vm.answer = _.capitalize(response.data.answer)
          vm.image = response.data.image
          vm.imageSeen = true
        })
        .catch(function (error) {
          vm.answer = 'Ошибка! Не могу связаться с API. ' + error
        })
    }
  }
})

var tabs = [
  {
    name: 'Home',
    component: {
      template: '<div>Home component</div>'
    }
  },
  {
    name: 'Posts',
    component: {
      template: '<div>Posts component</div>'
    }
  },
  {
    name: 'Archive',
    component: {
      template: '<div>Archive component</div>',
    }
  }
]

var tabsVue = new Vue({
  el: '#dynamic-component-demo',
  data: {
  	tabs: tabs,
    currentTab: tabs[0]
  }
})