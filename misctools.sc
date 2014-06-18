#!/usr/bin/env bash
#
# MiscTools
# Author: Eric T. Jorgensen
# Date: 10-Jun-2014
# License: GPL V2: http://www.gnu.org/licenses/gpl-2.0.html
#
# This is NOT a direct answer to an in-class lab assignment, but rather a
# similar-concepts alternate task.
#
# An example of general functions in a file to be included in any script
# that may need them... or sourceable on the shell itself to run as is.
# 

setcolors()
{
    # Give names to various color codes in case tput is not installed

    col_set_true=TRUE

    col_default='\e[0m'
    col_bold='\e[1m'

    col_black='\e[0;30m'
    col_red='\e[0;31m'
    col_green='\e[0;32m'
    col_yellow='\e[0;33m'
    col_blue='\e[0;34m'
    col_purple='\e[0;35m'
    col_cyan='\e[0;36m'
    col_white='\e[0;37m'
}

unsetcolors()
{
    # Unset the same color names, in case auto-export is used

    unset col_set_true
    unset col_default col_bold
    unset col_black col_red col_green col_yellow 
    unset col_blue col_purple col_cyan col_white
}

col_echo()
{
    # Color echo if the colors above are set

    local message="$1"; shift
    local col_on="${1:-default}"; shift
    local col_off="${1:-default}"

    if [[ $col_set_true ]]; then
        eval col_on=\$col_$col_on               # Convert name to $col_name
        eval col_off=\$col_$col_off
        echo -e "${col_on}${message}${col_off}"
    else
        echo -e "$message"
    fi
    return 0
}

valid_input()
{
    # Validate user input; requires non-empty input
    # $1 = Prompt
    # $2 = Regex pattern for validation (default printable)
    #
    # Usage:  var=$(valid_input "prompt" "regex")
    # ie:     var=$(valid_input "Die Roll <1-6>" "^[1-6]$")
    #         var=$(valid_input "Hex Digit" "^[0-9a-fA-F]"
    #
    local prompt="$1"; shift
    local options="${1:-[[:print:]]}"
    local input=""

    while [[ "$input" = "" ]] || [[ ! "$input" =~ $options ]]
    do
        read -p "${prompt}: " input
    done
    echo "$input"
    return 0
}

request_file()
{
    # Request readable file before continuing; fatal or not, it depends
    # General function; this doesn't sanitize file input

    [[ ! -e "$1" ]] && return 1         # Requested file doesn't exist
    [[ ! -f "$1" ]] && return 1         # ...is not a file
    [[ ! -r "$1" ]] && return 1         # ...is not readable
    return 0
}

request_dir()
{
    # Request readable directory for spelunking; fatal or not, it depends

    [[ ! -e "$1" ]] && return 1         # Requested dir does not exist
    [[ ! -d "$1" ]] && return 1         # ...is not a dir
    [[ ! -r "$1" ]] && return 1         # ...is not readable
    [[ ! -x "$1" ]] && return 1         # ...is not enterable
    return 0
}

require_format()
{
    # Check format of (text) database file, likely fatal, default printable
    # Can use request_file() above to verify readability to avoid errors

    local file="$1"; shift
    local format="${1:-[[:print:]]}"
    local line=""

    for line in $(cat "$file")
    do
        [[ ! "$line" =~ $format ]] && return 1      # Data format error
    done
    return 0
}

