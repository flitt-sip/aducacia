<template>
  <div class="desktop:w-2/3 flex justify-end py-2 backdrop-blur-2xl ">
    <label class="p-2 font-semibold text-gray-400 " for="city_choice">Выберите город:</label>
    <select class="bg-white border-2 border-green-600 rounded-full px-8 font-semibold tracking-tighter text-gray-400 "
            name="cars" id="city_choice" v-model="cityId">
      <option class="bg-green-100" v-for="(city,index) in cities" :key="index" :value="city.id">
        {{ city.name }}
      </option>
    </select>
  </div>
</template>

<script>
import {computed} from "vue"

export default {
  props: {
    cities: {
      type: Array,
      required: true,
    },
    cityId: String
  },

  watch: {
    cities: function (newVal, oldVal) {
      this.cityId = newVal[0].id
    }
  },

  setup(props, {emit}) {
    const cityId = computed({
      get: () => props.cityId,
      set: value => emit("update:cityId", value)
    })

    return {
      cityId,
    }
  },
}
</script>