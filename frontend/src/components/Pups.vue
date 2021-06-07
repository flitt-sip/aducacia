<template>

  <div id="paginator" class="flex justify-center text-gray-400 font-semibold desktop:w-2/3 py-4">
    <a href="#" class="transition hover:text-green-400 ml-6 flex items-center justify-center"
       @click="setActive( activeIdx - 1)">
      &laquo;
    </a>
    <template v-for="(pup,index) in pups">
      <a href="#"
         class="ml-6 transition hover:bg-green-400 rounded-full h-8 w-8 flex items-center justify-center hover:text-white"
         v-if="activeIdx !== index"
         @click="setActive(index)">
        {{ index + 1 }}
      </a>
      <a href="#"
         class="active ml-6 bg-green-400 rounded-full h-8 w-8 border-2 border-green-600 flex items-center justify-center text-white"
         v-if="activeIdx === index">
        {{ index + 1 }}
      </a>
    </template>
    <a href="#" class="ml-6 transition hover:text-green-400 flex items-center justify-center"
       @click="setActive(activeIdx + 1)">
      &raquo;
    </a>
  </div>

  <template v-if="pup">
    <div class="bg-green-100 text-gray-400 desktop:w-2/3">
      <div class="flex justify-center font-semibold">
        <div class="mr-5"> Интересует:</div>
        <div>{{ pup.teacherWanted }}</div>
      </div>
      <div class="flex justify-center">{{ pup.preferredPlace }}</div>
    </div>

    <figure class="desktop:w-2/3 text-justify ">
      <blockquote class="my-2 mb-8 text-gray-400 px-4">
        <h2 class="border-b-2 border-green-100 uppercase text-xl text-green-400 font-medium py-2">ребенок глазами
          родителей</h2>
        <p class="font-medium">{{ pup.pupName }}</p>
        <p> {{ pup.pupPortrait }} </p>
      </blockquote>
      <blockquote class="my-2 text-gray-400 bg-green-100 px-4 ">
        <h2 class="uppercase text-xl text-green-400 font-medium border-b-2 border-gray-100 py-2">учитель от бога глазами
          родителей</h2>
        {{ pup.teacherIdeal }}
      </blockquote>

      <blockquote class="my-2 text-gray-400 px-4 ">
        <h2 class="uppercase text-xl text-green-400 font-medium border-b-2 border-green-100 py-2">мысли родителей</h2>
        <h3 class="uppercase text-base text-gray-400 font-medium mt-3">отношение к государственной школе</h3>
        {{ pup.govEducationCons }}
        <div class="py-4"> {{ pup.govEducationPros }}</div>
        <h3 class="uppercase text-base text-gray-400 font-medium mt-3">Какая главная причина того, что Вы сейчас ищите
          Учителя? </h3>
        {{ pup.whyNeedTeacher }}
        <h3 class="uppercase text-base text-gray-400 font-medium mt-3">сотрудничество с учителем </h3>
        {{ pup.whatIsImportant }}
      </blockquote>
      <figcaption
          class="py-4 font-medium desktop:w-1/3 bg-gradient-to-b from-green-400 to-green-100 text-gray-600 rounded-xl p-8">
        <div>Контакты</div>
        <div>{{ pup.parentName }}:</div>
        <div><a href="tel:{{pup.phoneNumber}}">{{ pup.phoneNumber }}</a></div>
      </figcaption>
    </figure>

  </template>
</template>

<script>

import {computed} from "vue";

export default {
  props: {
    pups: {
      type: Array,
      required: true,
    }
  },

  watch: {
    pups: function (newVal, oldVal) {
      this.setActive(0)
    }
  },

  setup(props) {
    console.log(props.pups)
  },

  data() {
    return {
      pup: this.pups[0],
      activeIdx: 0
    }
  },
  methods: {
    setActive(idx) {
      if (idx >= 0 && idx < this.pups.length) {
        this.pup = this.pups[idx]
        this.activeIdx = idx;
      }
    },
  },
}
</script>